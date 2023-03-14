package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Test3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Test 01</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            border: 2px solid green;\n");
      out.write("            width: 400px;\n");
      out.write("            height: 300px;\n");
      out.write("            margin: auto;\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("        h3{\n");
      out.write("            margin-top: 0;\n");
      out.write("            color: blue;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .input{\n");
      out.write("            width: 150px;\n");
      out.write("            margin-right: 5px;\n");
      out.write("            word-wrap:break-word;\n");
      out.write("        }\n");
      out.write("        .submit{\n");
      out.write("            width: 50px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .reset{\n");
      out.write("            color: red;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .output1{\n");
      out.write("            width: 155px;\n");
      out.write("            height: 144px;\n");
      out.write("        }\n");
      out.write("        .output{\n");
      out.write("            width: 155px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"test3\">\n");
      out.write("            ");

                String a = "";
                if(request.getAttribute("a") != null)
                a = (String)request.getAttribute("a");
                String result1 = "";
                if(request.getAttribute("result1") != null)
                result1 = (String)request.getAttribute("result1");
                String result2 = "";
                if(request.getAttribute("result2") != null)
                result2 = (String)request.getAttribute("result2");
                String err = "";
                if(request.getAttribute("err") != null)
                err = (String)request.getAttribute("err");
            
      out.write("\n");
      out.write("            <h3>INPUT AND CALCULATE</h3>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><b><i>Enter an integer n:</i></b></td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input class=\"input\" type=\"text\" value=\"");
      out.print(a);
      out.write("\" name=\"a\">\n");
      out.write("                        <input class=\"submit\" type=\"submit\" value=\">>\">\n");
      out.write("                    </td>\n");
      out.write("                    <td rowspan=\"6\" align=\"center\"><input style=\"border: 1px solid blue\" class=\"output1\" type=\"text\" value=\"");
      out.print(result1);
      out.write("\" readonly></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td rowspan=\"3\" align=\"center\"><a href=\"Test3.jsp\" target=\"_parent\"><input class=\"reset\" type=\"button\" value=\"RESET\"></a></td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(err);
      out.write("</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(err);
      out.write("</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(err);
      out.write("</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Sum of number in list:</b></td>\n");
      out.write("                    <td><input class=\"output\" type=\"text\" value=\"");
      out.print(result2);
      out.write("\" readonly></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
