package com.atguigu.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 编码生成工具类.
 * @Author: dansheng
 * @CreateTime: 2024/10/14
 **/
public class NumberGeneratorUtils {

    /**
     * 生成交货单号
     *
     * @param sequence 序列号（按序增加的数字）
     * @return 生成的交货单号
     */
    public static String generateDeliveryNoteNumber(int sequence) {
        // 获取当前日期，格式为YYYYMMDD
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());

        // 确保序列为四位数字
        String formattedSequence = String.format("%04d", sequence);

        // 生成交货单号
        return "GI" + currentDate + formattedSequence;
    }

    public static void main(String[] args) {
        // 测试生成前5个交货单号
        for (int i = 1; i <= 5; i++) {
            String deliveryNoteNumber = generateDeliveryNoteNumber(i);
            System.out.println(deliveryNoteNumber);
        }
    }

}
