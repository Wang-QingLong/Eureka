package cn.itcast.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/14 17:52
 * @description:
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤的类型:pre route post error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，返回值越小，优先级越高
     * 之所以设置大，是为防止有多个过滤器
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行该过滤器
     * true: 执行run方法
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器的业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context 上下文对象，servlet spring
        RequestContext currentContext = RequestContext.getCurrentContext();

        //获取request对象
        HttpServletRequest request = currentContext.getRequest();

        //获取参数
        String token = request.getParameter("token");

        if (StringUtils.isBlank(token)) {
            //拦截，不转发请求
            currentContext.setSendZuulResponse(false);
            //响应状态码，401-身份未认证
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            currentContext.setResponseBody("李斌狗贼，哪里逃，休走...");
        }

        //返回null,就代表过滤器啥都不做
        return null;
    }
}
