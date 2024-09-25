package Intuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class WeatherStats {

    public WeatherStats() {}
    private TopK getTopKDataByTemp(int k, List<WeatherData> inputList) {
        PriorityQueue<WeatherData> tempQ = new PriorityQueue(new TempComparator());
        for(WeatherData cityData : inputList) {
            tempQ.add(cityData);
        }
        List<WeatherData> result = new ArrayList<>();

        while(k > 0) {
            WeatherData city = tempQ.poll();
            result.add(city);
            k--;
        } return new TopK(k, "TEMP", result);
    }
    private TopK getTopKDataByHumidity(int k, List<WeatherData> inputList) {

        /* Sort data */
        Collections.sort(inputList, new HumidityComparator());

        /* select data */
        List<WeatherData> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(inputList.get(i));
        }

        return new TopK(k, "HUMIDITY", result);
    }
    public TopK getTopKDataByStat(int k, String stat, List<WeatherData> inputList) throws Exception {
        TopK topk = null;
        switch(stat) {
        case "temp":
            topk = getTopKDataByTemp(k, inputList);
            break;
        case "humidity":
            topk = getTopKDataByHumidity(k, inputList);
            break;
        }
        return topk;
    }
    public static class TopK {
        private int k;
        private String stat;
        private List<WeatherData> dataList;

        public TopK(int k, String stat, List<WeatherData> dataList) {
            this.k = k;
            this.stat = stat;
            this.dataList = dataList;
        }

        public List<WeatherData> getDataList() {
            return this.dataList;
        }
    }
    public static class TempComparator implements Comparator<WeatherData> {
        public int compare(WeatherData c1, WeatherData c2) {
            if (c1.getTemp() < c2.getTemp())
                return 1;
            else if (c1.getTemp() > c2.getTemp())
                return -1;

            return 0;
        }    }
    public static void main(String[] args) {
        List<WeatherData> inputList = new ArrayList<>();

        /* Data setup */
        WeatherData mumbai = new WeatherData(1, "mumbai", 28, 14, 85);
        inputList.add(mumbai);
        WeatherStats ws = new WeatherStats();
        try {
            TopK tempTopk = ws.getTopKDataByStat(5, "temp", inputList);
            TopK humidityTopK = ws.getTopKDataByStat(5, "humidity", inputList);

            System.out.println(" ********* TEMP ********** ");
            for(WeatherData city : tempTopk.getDataList()) {
                System.out.println(city.toString());
            }

            System.out.println(" ********* HUMIDITY ********** ");
            for(WeatherData city : humidityTopK.getDataList()) {
                System.out.println(city.toString());
            }

            // TopK exceptionTest = ws.getTopKDataByStat(50, "humidity", inputList);  //  Expected exception: "Invalid k value"

        } catch(Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }

    }
    public static class HumidityComparator implements Comparator<WeatherData> {
        public int compare(WeatherData c1, WeatherData c2) {
            if (c1.getHumidity() < c2.getHumidity())
                return 1;
            else if (c1.getHumidity() > c2.getHumidity())
                return -1;
            return 0;
        }
    }
    public static class WeatherData {
        private int id;
        private String city;
        private int temp;
        private int pressurePsi;
        private int humidity;

        public WeatherData(int id, String city, int temp, int pressure, int humidity) {
            this.id = id;
            this.city = city;
            this.temp = temp;
            this.pressurePsi = pressure;
            this.humidity = humidity;
        }

        public String getCityName() {
            return this.city;
        }

        public int getTemp() {
            return this.temp;
        }

        public int getPressure() {
            return this.pressurePsi;
        }

        public int getHumidity() {
            return this.humidity;
        }

        @Override
        public String toString() {
            return "Weather={" +
                    "city='" + city + '\'' +
                    "temp=" +  temp + '\'' +
                    "humidity=" +  humidity + '\'' +
                    '}';
        }

    }
}
