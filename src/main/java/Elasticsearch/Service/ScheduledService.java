package Elasticsearch.Service;

//定时任务测试

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     *  A cron-like expression, extending the usual UN*X definition to include triggers
     * 	 * on the second秒, minute分, hour时, day of month日, month月, and day of week周几.
     * egg:  "0 * * * * MON-FRI"  从周一到周五  *表示任意时刻  0表示整秒启动
     *
     * 六个参数 秒 分 时 日 月 周
     * 周一到周五每一分钟（0秒）启动
     * "0 * * * * MON-FRI"
     * 1.枚举 "0,1,2,3 * * * * *"  任意时刻，0，1，2，3秒启动
     * 2.区间 "0-3 * * * * *"      任意时刻，0到3秒启动
     * 3.步长 "0/3 * * * * *"      从0秒启动，每4s执行一次
     * 4.  ? 用于日期和星期冲突匹配
     * 5. 星期几  0-7  1-6代表周一到周六  0和7都代表星期天
     *
     * egg:
     *   【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *   【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *   【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次  L表示最后一个
     *   【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次  W 表示工作日
     *   【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     */
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello");
    }

}





