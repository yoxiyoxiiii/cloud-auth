package cn.kr.authzuul.filters;

import cn.kr.authzuul.client.UserService;
import cn.kr.model.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul 的过滤器
 * 配置在zuul 中的所有url 都会经过 zuul的过滤器
 pre：路由之前
 routing：路由之时
 post： 路由之后
 error：发送错误调用
 filterOrder：过滤器的顺序
 shouldFilter：这里可以写逻辑判断，是否要过滤。
 run：过滤器的具体逻辑。
 */
@Slf4j
@Configuration
public class LoginFilter extends ZuulFilter {

    @Autowired
    private UserService userService;

    /**
     * 过滤器类型
     * String ERROR_TYPE = "error";
       String POST_TYPE = "post"; //声明为后置过滤器，在路由之后调用
       String PRE_TYPE = "pre"; //声明为前置过滤器，在路由之前调用
       String ROUTE_TYPE = "route";
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否使用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getHeader("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("401");
//            }catch (Exception e){}
            Result result = userService.toLogin();
            return result;
        }
        log.info("ok");
        return null;
    }
}
