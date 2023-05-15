package in.ineuron.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.BlogPost;

@WebServlet("/first")
public class CreateBlogPostServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the blog post creation form (create_blog_post.jsp)
        request.getRequestDispatcher("/WEB-INF/views/create_blog_post.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");


        // Create a new BlogPost object
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setDescription(description);
        blogPost.setContent(content);

        // Store the blog post data in the database (you'll need to implement a data access object)
        // dao.createBlogPost(blogPost);

        // Redirect to the blog post listing page (view_blog_posts.jsp)
        response.sendRedirect(request.getContextPath() + "/first");
    }
}