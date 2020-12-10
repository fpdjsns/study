import org.apache.commons.lang3.tuple.Pair;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class GithubApi {

    public List<Pair<String, Double>> getParticipationRates(String token, String repoName) throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(token).build();
        github.checkApiUrlValidity();

        GHRepository repo = github.getRepository(repoName);
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);

        // key = name, value = cnt
        Map<String, Integer> memberCnts = new HashMap<>();
        for (GHIssue issue : issues) {
            // get participants name
            List<String> participantNames = issue.getComments().stream().map(comment -> {
                try {
                    return comment.getUser().getName();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).distinct().collect(toList());

            participantNames.forEach(name -> memberCnts.merge(name, 1, Integer::sum));
        }

        int issueCnt = issues.size();
        List<Pair<String, Double>> participationRate = new ArrayList<>();
        for (String key : memberCnts.keySet()) {
            participationRate.add(Pair.of(key, (double)memberCnts.get(key) / issueCnt * 100));
        }
        return participationRate;
    }
}
