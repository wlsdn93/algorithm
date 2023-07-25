class Solution {
    public int garbageCollection(String[] house, int[] travel) {
        /*
            i -> i + 1 로 이동할 때 travel()
            i 부터 len - 1 까지의 위치중 더 이상 수거할 게 없으면 멈춤
        */
        int len = house.length;
        int total = 0;
        String[] garbageTypes = new String[]{"M", "P", "G"};
        for (String type : garbageTypes) {
            for (int i = 0; i < len; i++) {
                String[] garbages = house[i].split("");
                int count = countGarbages(garbages, type);
                // 해당 집에서 수거할 쓰레기가 있다면, 쓰레기 개수만큼 1분의 시간을 추가한다.
                if (count > 0) total += count;
                // 더 이상 수거할 해당 타입 쓰레기가 없으면 종료한다.
                if (!garbageLeft(house, type, i)) break;
                // 다음 지역으로 이동한다.
                if (i > 0) total += travel[i - 1];
            }
        }
        return total;
    }
    
    public boolean garbageLeft(String[] house, String type, int index) {
        int len = house.length;
        for (int i = index; i < len; i++) {
            if (house[i].contains(type)) return true;
        }
        return false;
    }
    
    public int countGarbages(String[] garbages, String type) {
        int count = 0;
        for (String garbage : garbages) {
            if (garbage.equals(type)) count++;
        }
        return count;
    }
}