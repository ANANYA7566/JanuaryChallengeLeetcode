/*
Idea behind this approach is finding all the missing elemnts before arr[0] then 
finding missing elements from arr[0] to arr[length-1] then if needed find missing element after arr[length-1].
This approach worked for 73/84 test cases only.
*/
class Solution {
    public int findKthPositive(int[] arr, int k){
        int missing = 0;
        int count =0;
        int index =0;
        //to find the missing number before arr[0]
        if(arr[0]!=1){
            missing = arr[0]-1;//
            count = missing;//
        }
        int num = arr[0];//1
        while(count < k && index<arr.length){
            if(arr[index] != num){
                missing = num;//17
                count++;//1
                num++;//3
            }
            else{
                index++;//1
                num++;//
            }
        }
        if(count <k && arr[0] != 1 && missing!=0 && index == arr.length){
            missing =arr[arr.length-1] + k - count;
        }
        else if(count<k &&missing!= 0){
            missing = missing+count;
        }
        else if(count <k && missing==0 && count==0){
            missing= arr.length+k;
            }
        else if(count > k){
            missing = missing -( missing-k);
        }
        return missing;
    }
    
}  
