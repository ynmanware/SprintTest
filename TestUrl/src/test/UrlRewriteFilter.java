package test;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UrlRewriteFilter implements Filter
{

   public void init(FilterConfig config) throws ServletException
   {
      //
   }

   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
         ServletException
   {
      HttpServletRequest httpRequest = (HttpServletRequest) req;
      
      //start
      final String VAR = "sd-hash-.*/";
      String requestedPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
      
      System.out.println("Filter resourcePath: " + requestedPath);
     
      String newResourcePath = requestedPath;         
      
      if ((Pattern.compile(VAR).matcher(requestedPath).find()))
      {
         newResourcePath = requestedPath.replaceAll(VAR, "");
         System.out.println("FORWARDING TO: " + newResourcePath);
         req.getRequestDispatcher(newResourcePath).forward(req, res);
      }
      else
      {
         chain.doFilter(req, res);
      }
   }

   public static void main(String[] args)
   {
      String VAR = "/hash-[\\d]";
      String url = "http://localhost:8080/TestUrl/js/hash-1/app.js";
      String newResourcePath = url;
      if ((Pattern.compile(VAR).matcher(url).find()))
      {
         newResourcePath = url.replaceAll(VAR, "");
      }
      System.out.println(newResourcePath);

      // expecting newResourcePath to be "http://localhost:8080/TestUrl/js/app.js", but
      // there is no impact of replacement
   }

   public void destroy()
   {
      //
   }
}
