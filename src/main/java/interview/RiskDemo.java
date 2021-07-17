package interview;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by land.shen on 2021/5/12.
 */
public class RiskDemo {
    private static Long lastTriggerTime = 0L;
    private static Map<String,TreeMap<Long,Long>> cacheRisk = new ConcurrentHashMap<>();
    private static Map<String,TreeSet<Long>> cacheHasOcurrRisk = new ConcurrentHashMap<>();
    private static int triggerInterval = 5;
    public static void main(String[] args) {
        riskAssessment("test 1582251501 Ngmmms");
    }

    /**
     * 每个5秒统计最60秒的风险次数
     * @param log
     */
    public static void riskAssessment(String log){
        String[] datas = log.split("\t");
        if(datas==null || datas.length <3) return;
        String orgId = datas[0];
        Long updateAt = Long.valueOf(datas[1]);
        if(lastTriggerTime==0){
            lastTriggerTime = updateAt;
        }

        TreeMap<Long,Long> orgCount = cacheRisk.get(orgId);
        if(orgCount==null){
            cacheRisk.put(orgId,orgCount = new TreeMap<>());
        }
        Long timeCnt = orgCount.containsKey(updateAt) ? orgCount.get(updateAt) +1 : 1;

        orgCount.put(updateAt,timeCnt);
        TreeSet<Long> ocurrRisk =cacheHasOcurrRisk.get(orgId);
        if(ocurrRisk==null){
            cacheHasOcurrRisk.put(orgId,ocurrRisk = new TreeSet<>());
        }
        if(timeCnt>50 ) {
            ocurrRisk.add(updateAt);
        }
        //计算
        if(updateAt-lastTriggerTime>triggerInterval)
        {
            for(Map.Entry<String,TreeMap<Long,Long>> kv: cacheRisk.entrySet()){
                while (updateAt-kv.getValue().firstKey() >60){
                    kv.getValue().pollFirstEntry();
                }

                TreeSet<Long> hasRisk= cacheHasOcurrRisk.get(kv.getKey());
                if(hasRisk.size()>0) {
                    while (updateAt - hasRisk.first() > 60) {
                        hasRisk.pollFirst();
                    }
                }
                if(hasRisk.size()>40){
                    System.out.println("{"+kv.getKey()+"}异常活跃");
                }

                lastTriggerTime = updateAt;
            }

        }
    }
}