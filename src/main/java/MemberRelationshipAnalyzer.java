import java.util.*;

class Member {
    private String memberId;
    private String memberType;
    private String actualControllerId;
    private String legalRepresentativeId;

    public Member(String memberId, String memberType, String actualControllerId, String legalRepresentativeId) {
        this.memberId = memberId;
        this.memberType = memberType;
        this.actualControllerId = actualControllerId;
        this.legalRepresentativeId = legalRepresentativeId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public String getActualControllerId() {
        return actualControllerId;
    }

    public String getLegalRepresentativeId() {
        return legalRepresentativeId;
    }
}

class RelationshipGraph {
    private Map<String, List<String>> graph;

    public RelationshipGraph() {
        graph = new HashMap<>();
    }

    public void addEdge(String from, String to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    public List<String> getNeighbors(String node) {
        return graph.getOrDefault(node, Collections.emptyList());
    }
}

public class MemberRelationshipAnalyzer {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();

        // 添加一些示例数据
        members.add(new Member("1", "个人", null, null));
        members.add(new Member("2", "企业", "3", "4"));
        members.add(new Member("3", "个人", null, null));
        members.add(new Member("4", "个人", null, null));
        members.add(new Member("5", "企业", "6", "7"));
        members.add(new Member("6", "个人", null, null));
        members.add(new Member("7", "个人", null, null));

        // 创建关系图
        RelationshipGraph graph = buildGraph(members);

        // 查找关联关系
        List<List<String>> groups = findGroups(graph);

        // 打印结果
        for (List<String> group : groups) {
            System.out.println("Group: " + group);
        }
    }

    private static RelationshipGraph buildGraph(List<Member> members) {
        RelationshipGraph graph = new RelationshipGraph();

        for (Member member : members) {
            if ("企业".equals(member.getMemberType())) {
                if (member.getActualControllerId() != null) {
                    graph.addEdge(member.getMemberId(), member.getActualControllerId());
                }
                if (member.getLegalRepresentativeId() != null) {
                    graph.addEdge(member.getMemberId(), member.getLegalRepresentativeId());
                }
            }
        }

        return graph;
    }

    private static List<List<String>> findGroups(RelationshipGraph graph) {
        List<List<String>> groups = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.getNeighbors("1")) { // Assuming "1" is the starting point
            List<String> group = new ArrayList<>();
            dfs(graph, node, visited, group);
            if (!group.isEmpty()) {
                groups.add(group);
            }
        }

        for (String node : graph.getNeighbors("5")) { // Assuming "5" is another starting point
            List<String> group = new ArrayList<>();
            dfs(graph, node, visited, group);
            if (!group.isEmpty()) {
                groups.add(group);
            }
        }

        // Add unconnected nodes
        for (String node : graph.getNeighbors("1")) {
            if (!visited.contains(node)) {
                groups.add(Collections.singletonList(node));
            }
        }

        return groups;
    }

    private static void dfs(RelationshipGraph graph, String node, Set<String> visited, List<String> group) {
        if (!visited.contains(node)) {
            visited.add(node);
            group.add(node);

            for (String neighbor : graph.getNeighbors(node)) {
                dfs(graph, neighbor, visited, group);
            }
        }
    }
}