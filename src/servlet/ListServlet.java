package servlet;

import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        StringBuffer sb = new StringBuffer();
        List<Hero> heros = new HeroDao().list();
        sb.append("<table align=\"center\" border=\"1\" cellspacing=\"1\">");
        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>");
        String format = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href=\"/editHero?id=%d\">edit</a></td><td><a href=\"/deleteHero?id=%d\">delete</a></td></tr>";
        for (Hero hero : heros) {
            String tr = String.format(format, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId(), hero.getId());
            sb.append(tr);
        }
        sb.append("</table>");
        resp.getWriter().print(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
