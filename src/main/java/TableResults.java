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
        output = new StringBuilder("<html><h1>Results<br>");
        for (User user : users) {
            output.append(user.getFirstName()).append(" ").append(user.getLastName()).append("<br>");
        }
        return Response.status(200).entity(output.toString()).build();
    }
}
