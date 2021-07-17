package interview;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

/**
 * 方法1. 接收一条数据为参数，orgid timestamp
 * 实现：
 *  同一个orgId在一秒钟内（updated_at）出现次数超过50次记为一次风险，
 *  (（time-orgid）,count) if count > 50 (（time-orgid）,fx+1)
 *  如果在连续的60秒内风险次数大于40次，打印：{orgId}异常活跃
 *      for(time-1) 拿到每个时间点的orgid和对应的风险计数聚合，如过这个orgid大于40次就报警
 */
public class RiskWarning {

    private static final Log LOG = LogFactory.getLog(RiskWarning.class);

    //存储一秒钟内rogid出现的次数:k:line,v:count
    private HashMap<String, Integer> line2Cts = new HashMap<>();
    //存储超过50次记一次的风险次数
    private HashMap<String, Integer> warnCtsMap = new HashMap<>();

    public void process(String line){
        String[] split = line.split("\t");
        if (split.length < 2) {
            LOG.info("error line "+ line);
            return;
        }

        String orgId = split[0];
        int time = Integer.parseInt(split[1]) - 60;

        line2Cts.forEach((k, v) ->{
        });


        int count = line2Cts.getOrDefault(line, 0) + 1;
        line2Cts.put(line, count);
        if (count > 50) {
            warnCtsMap.put(line, warnCtsMap.getOrDefault(line, 0) + 1);
        }

        /**
         * 统计60秒内出现次数之和
         */
        HashMap<String, Integer> id2Cts = new HashMap<>();
        for (int i = 60; i >= 0; i--) {
            Integer sum = warnCtsMap.get(orgId + "\t" + (time - i));
            sum = id2Cts.getOrDefault(orgId, 0) + sum;
            id2Cts.put(orgId, sum);
            if (sum > 40) {
                System.out.println(orgId+"异常");
            }
        }
    }
}
