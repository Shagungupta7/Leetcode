class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        HashSet<String> visited = new HashSet<>(); // Track visited words
        HashSet<String> wordSet = new HashSet<>(wordList); // Convert wordList to set for quick lookup
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        visited.add(beginWord);
        int length = 1; // Start from 1 since we count the initial word

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endWord)) return length; // Found the endWord
                
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue; // Skip the original character
                        
                        arr[j] = c;
                        String word = new String(arr);

                        if (wordSet.contains(word) && !visited.contains(word)) {
                            q.offer(word);
                            visited.add(word);
                        }
                    }
                    arr[j] = original; // Restore original character
                }
            }
            length++; // Increase length only after processing all words at current level
        }
        return 0;
    } // No transformation sequence found
}
