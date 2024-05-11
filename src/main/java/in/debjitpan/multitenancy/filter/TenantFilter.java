package in.debjitpan.multitenancy.filter;

import in.debjitpan.multitenancy.config.TenantContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String tenantId = request.getHeader("X-TenantId");
        TenantContext.setCurrentTenantDbName(tenantId);

        filterChain.doFilter(servletRequest, servletResponse);
        TenantContext.clear();
    }
}
