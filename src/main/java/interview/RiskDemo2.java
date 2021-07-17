package interview;

import java.util.*;

public class RiskDemo2 {

    //最近一次更新 orgId : last_updated_at
    private Map<String,Long> latestMap = new HashMap<>();
    //更新次数 orgId : last_updated_at_times
    private Map<String,Long> timesMap = new HashMap<>();
    //orgId : 风险时间点
    private Map<String, List<Long>> timesStorage = new HashMap<>();


    public void  solve(String content){
        String[] data = content.split("\t");
        for(String d:data){
            String[] temp = d.split(" ");
            String orgId = temp[0];
            Long updated_at = Long.valueOf(temp[1]);
            Long last_updated_at = latestMap.get(orgId);
            if(last_updated_at!=null && last_updated_at.equals(updated_at)){
                timesMap.put(orgId,timesMap.get(orgId)+1);
            }else{
                latestMap.put(orgId,updated_at);
                timesMap.put(orgId,1L);
            }

            if(timesMap.get(orgId)>= 50){
                List<Long> t =  timesStorage.get(orgId);
                if(t==null){
                    t = new LinkedList<>(Collections.singletonList(updated_at));
                }
                else {
                    Long left = (new Date()).getTime()/1000 - 60;
                    while (!t.isEmpty() && t.get(0)<left) t.remove(0);
                    t.add(updated_at);
                }
                if(t.size()>= 40){
                    System.out.printf("%s异常活跃%n",orgId);
                }
                else
                    timesStorage.put(orgId,t);
                timesMap.put(orgId,-Long.MAX_VALUE);
            }
        }
    }

    public static void main(String[] args) {
        RiskDemo2 solution = new RiskDemo2();
        solution.solve("a 1621257300 data\ta 1621257300 data\ta 1621257301 data\ta 1621257301 data\ta 1621257302 data\ta 1621257302 data");
    }
}
