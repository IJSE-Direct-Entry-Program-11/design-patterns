package simulation;

public class Demo {

    public static void main(String[] args) {
        Tomcat.initializeServlets();    // App-deploy (5)

        System.out.println(Tomcat.servlet.getServletConfig().getServletContext());
    }
}

interface ServletConfig{
    String getServletContext();
}

interface Servlet{
    ServletConfig getServletConfig();
    void init(ServletConfig servletConfig);
}

class GenericServlet implements Servlet, ServletConfig {

    private ServletConfig sc;

    public ServletConfig getServletConfig(){
        return sc;
    }

    @Override
    public void init(ServletConfig servletConfig) {
        this.sc = servletConfig;
        // init();
    }

    @Override
    public String getServletContext() {
        return sc.getServletContext();
    }
}

class Tomcat{
    private static String servletContext = "I am servlet context";

    public static GenericServlet servlet;
    public static void initializeServlets(){
        var ref = new GenericServlet();
        var configRef = new ServletConfig(){
            @Override
            public String getServletContext() {
                return servletContext;
            }
        };
        ref.init(configRef);
        servlet = ref;
    }
}
