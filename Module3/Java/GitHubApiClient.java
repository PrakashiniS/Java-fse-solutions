import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GitHubApiClient {
    private static final String GITHUB_API_URL = "https://api.github.com";
    private final HttpClient httpClient;

    public GitHubApiClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public String getUserInfo(String username) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GITHUB_API_URL + "/users/" + username))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to get user info: " + response.statusCode());
        }
    }

    public String getRepositories(String username) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GITHUB_API_URL + "/users/" + username + "/repos"))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to get repositories: " + response.statusCode());
        }
    }

    public static void main(String[] args) {
        try {
            GitHubApiClient client = new GitHubApiClient();
            String username = "octocat";

            System.out.println("Fetching user info for " + username + "...");
            String userInfo = client.getUserInfo(username);
            System.out.println("User Info: " + userInfo);

            System.out.println("\nFetching repositories for " + username + "...");
            String repos = client.getRepositories(username);
            System.out.println("Repositories: " + repos);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}