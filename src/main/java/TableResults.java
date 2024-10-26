import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/results")
public class TableResults {
    @GET
    @Produces("text/html")
    public Response getTable() {
        UserDao userDao = new UserDao();
        List<User> users = new ArrayList<>();
        users = userDao.getAll();
        StringBuilder output;
        output = new StringBuilder("<html>");
        output.append("<body><h1>Results</h1><br>");
        output.append("<table border='1px solid;'><tr><th>first name</th><th>last name</th></tr>");
        for (User user : users) {
            output.append("<tr><td>").append(user.getFirstName()).append("</td><td>").append(user.getLastName()).append("</td></tr>");
        }
        output.append("</table></html>");
        return Response.status(200).entity(output.toString()).build();
    }
}
