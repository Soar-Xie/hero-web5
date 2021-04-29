package servlet;

import bean.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        StringBuffer sb = new StringBuffer();
        Hero hero = new HeroDao().get(Integer.parseInt(req.getParameter("id")));
        sb.append("<form action=\"/updateHero\" method=\"post\">");
        sb.append("<input type=\"hidden\" name=\"id\" value=\"%d\">");
        sb.append("姓名：<input type=\"text\" name=\"name\" value=\"%s\"><br>");
        sb.append("血量：<input type=\"text\" name=\"hp\" value=\"%f\"><br>");
        sb.append("伤害：<input type=\"text\" name=\"damage\" value=\"%d\"><br>");
        sb.append("<input type=\"submit\" value=\"提交修改\">");
        sb.append("</form>");
        String format = String.format(sb.toString(), hero.getId(), hero.getName(), hero.getHp(), hero.getDamage());
        resp.getWriter().write(format);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
