class Solution {
    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();
        int len = arr.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int distance = countDistance(arr, i);
            answer[i] = distance;
        }
        return answer;
    }
    
    public int countDistance(char[] boxes, int index) {
        int len = boxes.length;
        int distance = 0;
        for(int i = 0; i < len; i++) {
            if (boxes[i] == '1') {
                distance += Math.abs(i - index);
            }
        }
        return distance;
    }
}