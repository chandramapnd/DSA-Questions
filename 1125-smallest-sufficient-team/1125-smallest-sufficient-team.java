class Solution {
    List<Integer> res = new ArrayList<>();
    Map<String, Integer> dp = new HashMap();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(req_skills[i], i);
        }
        List<Integer> peop = new ArrayList<>();
        for(List<String> lst : people){
            int skill_bit = 0;
            for(String skill : lst){
                skill_bit = skill_bit | (1 << map.get(skill));
            }
            peop.add(skill_bit);
        }

        int target = (int)Math.pow(2, n) - 1;

        solve(peop, 0, new ArrayList<>(), 0, target);
        
        int []ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public void solve(List<Integer> people, int i, List<Integer> temp, int mask, int target){
        if(i == people.size()){
            if(mask == target){
                if(res.size() == 0 || res.size()>temp.size()){
                    res = new ArrayList(temp);
                }
            }
            return;
        }

        if(res.size() != 0 && res.size() <= temp.size()){
            return;
        }

        String key = mask + " "+ i;
        if(dp.containsKey(key)){
            if(dp.get(key)<= temp.size()){
                return;
            }
        }

        solve(people, i+1, temp, mask, target);


        if(mask != (mask | people.get(i))){
            temp.add(i);
            solve(people, i+1, temp, mask | people.get(i), target);
            temp.remove(temp.size()-1);

            dp.put(key, (temp.size() ==0 ? -1 : temp.size()));
        }
    }
}