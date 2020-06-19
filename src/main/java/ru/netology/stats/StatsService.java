package ru.netology.stats;


/**
 * написать небольшой сервис, который умеет рассчитывать:
 * <p>
 * 1.    Сумму всех продаж  -   totalSales
 * 2.    Среднюю сумму продаж в месяц   - averageSalesMonth
 * 3.    Номер _последнего_ месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)    - maxSalesMonth
 * 4.    Номер _последнего_ месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму) - minSalesMonth
 * 5.    Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)     - monthsBelowAverage
 * 6.    Кол-во месяцев, в которых продажи были выше среднего (см. п.2)     - monthsAboveAverage
 */
public class StatsService {


    public int totalSales(int[] sales) {
        int sum = 0;
        for (int monthlySale : sales) {
            sum += monthlySale;
        }
        return sum;
    }

    public float averageSalesMonth(int[] sales) {
        return totalSales(sales) / sales.length;

    }

    public int maxSalesMonth(int[] sales) {
        int maxMonth = 0; // номер элемента с наибольшим числом продаж
        int i = 0; // номер текущего элемента массива
        for (int monthlySale : sales) {
            if (monthlySale >= sales[maxMonth]) {
                maxMonth = i;
            }
            i++;
        }
        return maxMonth + 1; // номер месяца отличается от номера в массиве
    }

    public int minSalesMonth(int[] sales) {
        int minMonth = 0; // номер элемента с наименьшим числом продаж
        int i = 0; // номер текущего элемента массива
        for (int monthlySale : sales) {
            if (monthlySale <= sales[minMonth]) minMonth = i;
            i++;
        }
        return minMonth + 1; // номер месяца отличается от номера в массиве
    }

    public int monthsAboveAverage(int[] sales) {
        int monthes = 0;
        float average = averageSalesMonth(sales);
        for (int monthlySale : sales) {
            if (monthlySale > average) monthes++;
        }
        return monthes;

    }

    public int monthsBelowAverage(int[] sales) {
        int monthes = 0;
        float average = averageSalesMonth(sales);
        for (int monthlySale : sales) {
            if (monthlySale < average) monthes++;
        }
        return monthes;
    }

}
