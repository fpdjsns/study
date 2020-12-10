import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class GithubApiTest {

    GithubApi githubApi = new GithubApi();

    @Test
    void githubConnectTest() {
        String token = "520595818e833c58069146a971171b94d009274e";
        String repoName = "whiteship/live-study";

        List<Pair<String, Double>> rates = new ArrayList<>();
        try {
            rates = githubApi.getParticipationRates(token, repoName);
        } catch (Exception e) {
            fail();
        }

        rates.forEach(rate -> System.out.println(rate.getLeft() + ": " + rate.getRight()));
    }

}
