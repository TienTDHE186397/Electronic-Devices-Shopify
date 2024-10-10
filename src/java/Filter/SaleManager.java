/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package Filter;

import Entity.Person;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Duc Long
 */
@WebFilter(filterName = "SaleManager", urlPatterns = {"/SaleHomeManager",})
public class SaleManager implements Filter {
<<<<<<< HEAD
=======
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public SaleManager() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("SaleManager:DoBeforeProcessing");
        }

    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("SaleManager:DoAfterProcessing");
        }

    }

   
>>>>>>> ef1a0d948d38efeb2d9d1596cdc1815f7a8c72b6
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
<<<<<<< HEAD
=======
        if (debug) {
            log("SaleManager:doFilter()");
        }
        
        doBeforeProcessing(request, response);
>>>>>>> ef1a0d948d38efeb2d9d1596cdc1815f7a8c72b6
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            res.sendRedirect("home");
        } else {
            Person account = (Person) session.getAttribute("user");
            if (account.getRoleID() != 4) {
                res.sendRedirect("home");
            }
        }
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
          
            problem = t;
            t.printStackTrace();
        }
        
<<<<<<< HEAD
      
=======
        doAfterProcessing(request, response);
>>>>>>> ef1a0d948d38efeb2d9d1596cdc1815f7a8c72b6
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

<<<<<<< HEAD
=======
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

   
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("SaleManager:Initializing filter");
            }
        }
    }

   
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("SaleManager()");
        }
        StringBuffer sb = new StringBuffer("SaleManager(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
>>>>>>> ef1a0d948d38efeb2d9d1596cdc1815f7a8c72b6
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
<<<<<<< HEAD
 
=======
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
>>>>>>> ef1a0d948d38efeb2d9d1596cdc1815f7a8c72b6
    
}
