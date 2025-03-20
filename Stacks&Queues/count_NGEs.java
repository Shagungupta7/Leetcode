class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int[] ans = new int[queries];
    int[] nge = new int[N];
    
    Stack<Integer> desc = new Stack<>();
    Stack<Integer> asc = new Stack<>();
    
    for(int i = arr.length-1; i >= 0; i--){
        while(!desc.isEmpty() && desc.peek() <= arr[i]){
            asc.push(desc.pop());
        }
        if(desc.isEmpty()) nge[i] = 0;
        else nge[i] = desc.size();
        desc.push(arr[i]);
        while(!asc.isEmpty()) desc.push(asc.pop());
    }
    
    for(int i = 0; i < queries; i++){
        ans[i] = nge[indices[i]];
    }
    
    return ans;
  }
}
 
