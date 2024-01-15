// Time: O(n + k) n=length of matches, k = range of winner and loser values, Space: O(k)

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossesCount = new int[100001];
        Arrays.fill(lossesCount, -1);

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            if (lossesCount[winner] == -1) {
                lossesCount[winner] = 0;
            }
            if (lossesCount[loser] == -1) {
                lossesCount[loser] = 1;
            } else {
                lossesCount[loser]++;
            }
        }

        List<List<Integer>> answer =
            Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; ++i) {
            if (lossesCount[i] == 0) {
                answer.get(0).add(i);
            } else if (lossesCount[i] == 1) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
}

// 2nd sol
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> score = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] match : matches){
            min = Math.min(min, Math.min(match[0], match[1]));
            max = Math.max(max, Math.max(match[0], match[1]));
            score.put(match[0], score.getOrDefault(match[0], 0));
            score.put(match[1], score.getOrDefault(match[1], 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int i = min; i<=max; i++){
            if(score.getOrDefault(i, -1) == 0){
                ans.get(0).add(i);
            }

            if(score.getOrDefault(i, -1) == 1){
                ans.get(1).add(i);
            }
        }

        return ans;
    }
}
