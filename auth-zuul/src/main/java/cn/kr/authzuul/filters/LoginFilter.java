package cn.kr.authzuul.filters;

import cn.kr.authzuul.client.UserService;
import cn.kr.model.Result;
import cn.kr.utils.JsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *登陆过滤器
 * zuul 的过滤器
 * 配置在zuul 中的所有url 都会经过 zuul的过滤器
 pre：路由之前
 routing：路由之时
 post： 路由之后
 error：发送错误调用
 filterOrder：过滤器的顺序
 shouldFilter：这里可以写逻辑判断，是否要过滤。
 run：过滤器的具体逻辑。
 * @author Administrator
 */
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

    /**
     * filter 逻辑处理处
     * @return
     */
    @Override
    public Object run() {
        //从 http 头中获取token
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token) || !userService.isLogin().getData()) {
            //过滤该请求，不对其进行路由分发，也就是说 请求不会到达对应的 微服务。
            requestContext.setSendZuulResponse(false);
            Result result = Result.fail(401);
            String json = JsonUtil.objectToJson(result);
            try {
                requestContext.getResponse().getWriter().write(json);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
