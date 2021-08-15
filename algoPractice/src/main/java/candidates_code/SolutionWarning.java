package candidates_code;



import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author jihua.chai
 * @Description
 * @Date 2021/6/24 下午8:16
 **/
public class SolutionWarning {
    final Integer COLUMNS_SIZE = 3;
    final Integer WARNING_TIMES = 50;
    final Integer WARNING_TIMES_TOTAL = 40;
    static final Map<String, List<Cell>> warningMap = new ConcurrentHashMap<>();

    private static class Cell {
        int time;
        AtomicInteger times;

        Cell(int time, AtomicInteger times) {
            this.time = time;
            this.times = times;
        }
    }

    public String warningOrg(String s) {
        String[] columns = s.split("\t");
        if (columns.length == COLUMNS_SIZE) {
            List<Cell> cur;
            if ((cur = warningMap.get(columns[0])) != null) {
                cur.removeIf(o -> o.time < (Integer.parseInt(columns[1]) - 60));
                for (Cell c : cur) {
                    if (c.time == Integer.parseInt(columns[1])) {
                        c.times.getAndIncrement();
                        return warningTimes(columns[0]);
                    }
                }
                cur.add(new Cell(Integer.parseInt(columns[1]), new AtomicInteger(Integer.parseInt(columns[2]))));
            } else {
                cur = new LinkedList<>();
                cur.add(new Cell(Integer.parseInt(columns[1]), new AtomicInteger(Integer.parseInt(columns[2]))));
                warningMap.put(columns[0], cur);
            }
            return warningTimes(columns[0]);
        }
        return null;
    }

    private String warningTimes(String orgId) {
        int w = (int) warningMap.get(orgId).stream().filter(o -> o.times.get() > WARNING_TIMES).count();
        if (w > WARNING_TIMES_TOTAL) {
            return orgId;
        }
        return null;
    }
}