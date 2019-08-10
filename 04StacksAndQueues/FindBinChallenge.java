class FindBinChallenge {
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<String>(number + 1);
        queue.enqueue("1");
        for (int i=0; i<number; i++) {
            result[i] = queue.dequeue();
            String s0 = result[i] + "0";
            String s1 = result[i] + "1";
            queue.enqueue(s0);
            queue.enqueue(s1);
        }
        return result;
    }
}
