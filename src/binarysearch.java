package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.*;

public class binarysearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("binarysearch");
        int n = input.getNum(in);
        switch(n){
            case 1: // find first and last index of a element in sorted array
                System.out.println(Arrays.toString(searchRange(input.getNumArrAsen(in),input.getNum(in))));
                break;
            case 2: // find element index in sorted array
                System.out.println(binsearchelementindx(input.getNumArrAsen(in),input.getNum(in)));
                break;
            case 3: // search in a 2D matrix
                System.out.println(searchMatrix(input.get2dNumArr(in),input.getNum(in)));
                break;
            case 4: // count negative in a 2D matrix
                System.out.println(countNegatives(input.get2dNumArr(in)));
                break;
            case 5: // arrange coins
                System.out.println(arrangeCoins(input.getNum(in)));
                break;
            case 6: // Find Right Interval
                System.out.println(Arrays.toString(findRightInterval(input.get2dNumArr(in))));
                break;
            case 7: // Find Nearer Index
                System.out.println(findNearIndx(input.getNumArr(in),input.getNum(in)));
                break;
            case 8: // Search in a rotated array
                System.out.println(search(input.getNumArr(in),input.getNum(in)));
                break;
            case 9: // Find single element
                System.out.println(singleNonDuplicate(input.getNumArr(in)));
                break;
            case 10: // Find Nth root
                System.out.println(NthRoot(input.getNum(in),input.getNum(in)));
                break;
            case 11: // Koko eating bannana
                System.out.println(minEatingSpeed(input.getNumArr(in),input.getNum(in)));
                break;
            case 12 : //Median in a row-wise sorted Matrix
                System.out.println(median(input.get2dNumArr(in),input.getNum(in),input.getNum(in)));
                break;
            case 13 : //Find Smallest Letter Greater Than Target
                System.out.println(nextGreatestLetter(input.getCharArr(in),input.getChar(in)));
                break;
            case 14: //Find the middle occurrence of X in the given array
                System.out.println(findMiddleOccurceArr(input.getNumArrAsen(in),input.getNum(in)));
                break;
            case 15 : //Counting elements in two arrays
                System.out.println(countEleLessThanOrEqual(input.getNumArr(in),input.getNumArr(in),input.getNum(in),input.getNum(in)));
                break;
            case 16 : //House robber IV
                System.out.println(minCapability(input.getNumArr(in),input.getNum(in)));
                break;
            case 17 : //Aggressive Cows
                System.out.println(aggressiveCows(input.getNumArr(in),input.getNum(in)));
                break;
            case 18 : //Allocate minimum number of pages
                System.out.println(findPages(input.getNumArrAsen(in),input.getNum(in),input.getNum(in)));
                break;
            case 19 : //Allocate minimum number of pages
                System.out.println(maxJump(input.getNumArrAsen(in)));
                break;
            case 20 : //Minimize the Maximum Difference of Pairs
                System.out.println(minimizeMax(input.getNumArr(in),input.getNum(in)));
                break;
            case 21 : //Maximum number of stock portfolios
                System.out.println(deShawMaxPort(input.getNumArr(in),input.getNum(in)));
                break;
            case 22 : //minimize maximum possible value Google
                System.out.println(googleMinArr(input.getNumArr(in)));
                break;
            case 23 : //longest contigious subarray of equal value Amazon
                System.out.println(amazonLongSubArr(input.getNumArr(in),input.getNum(in)));
                break;
            case 24: //Job Scheduler (PayPal)
                System.out.println(paypalJobSchedule(input.getNum(in),input.getNum(in),input.getNum(in)));
                break;
            case 25: //Time for truck to deliver (Infosys)
                System.out.println(infosysTruckTime(input.getNum(in),input.getNumArr(in)));
                break;
            case 26: //Maximum possible greatness in a Array
                System.out.println(maxPosGreat(input.getNumArrAsen(in)));
                break;
            case 27: //Maximum Chocolate in Triangle days.
                System.out.println(maxChacoDay(input.getNum(in)));
                break;
        }
        in.close();
    }

    public static int[] searchRange(int[] nums,int target){
        int[] ans = {-1,-1};
        ans[0]=binsearchtwoind(nums,target,true);
        if(ans[0]!=-1){
            ans[1]=binsearchtwoind(nums,target,false);
        }
        return ans;
    }
    public static boolean findHour(int[] piles, int h, int k){
        for (int p : piles) {
			h -= (int)((p + k-1) / (double)k);
			if (h < 0) return false;
		}
		return true;
    }
    public static int findless(int[][]matrix,int r,int tar)
    {
        int idx=-1;
        int lo=0;
        int hi=matrix[r].length-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(matrix[r][mid]<=tar)
            {
                idx=mid;
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        int nele=idx+1;
        return nele;
    }
    public static boolean isPossibleMinCapability(int[] nums,int mid,int k){
        int lastStolenIndex = -2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid && lastStolenIndex + 1 < i){
                lastStolenIndex=i;
                k=k-1;
                if(k==0) return true;
            }
        }
        return false;
    }
    public static boolean isPossibleCows(int a[], int n, int cows, int minDist) {
        int count = 1;
        int prev = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i]-prev >= minDist) {
                count++;
                prev = a[i];
            }
        }
        if (count >= cows) return true;
        return false;
    }
    public static boolean isPossiblePage(int[] nums,int n,int m,int mid){
        int stuCount=0,cursum=0;
        for(int i=0;i<n;i++){
            cursum=nums[i];
            if(cursum>mid){
                stuCount++;
                cursum=nums[i];
            }
        }
        return stuCount<=m;
    }
    public static boolean isPossibleFrogJump(int[] stones, int maxJump){
        int n=stones.length;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++){
            if(i==n-1) break;
            else if(i+1==n-1){
                if(i!=0) visited.add(i);
                break;
            }
            else if(stones[i+2]-stones[i] <= maxJump){
                if(i != 0) visited.add(i);
            }
             else return false;
        }
        for(int i=n-1;i>=0;i--){
            if(i==0) break;
            else if(i-1==0){
                if(stones[i]-stones[i-1] <= maxJump) break;
                else return false;
            }
            else if( visited.contains(i-1) ){
                if (!(stones[i]-stones[i-2] <= maxJump)) return false; 
            }
        }
        return true;
    }
    public static int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
    public static boolean googleMinArrPossible(int m,int[] nums){
        int g[]=new int[nums.length];
        for(int i=0;i<nums.length;i++) g[i]=nums[i];
        for(int i=nums.length-1;i>=1;i--) g[i-1]=g[i-1]+Math.abs(g[i]-m);
        return g[0]<=m;
    }
    public static boolean amazonLongPossible(ArrayList<Integer> subList,int m,int k){
        int x=0;
        for(int i=1;i<m;i++) x=x+(subList.get(i)-subList.get(i-1)-1);
        if(x<=k) return true;
        for(int i=m;i<subList.size();i++){
            x=x+(subList.get(i)-subList.get(i-1)-1);
            x=x-(subList.get(i-m+1)-subList.get(i-m)-1);
            if(x<=k) return true;
        }
        return false;
    }
    public static int paypalJobSchedulePossible(int n, int m,int k,int val){
        int retVal=0,l=val,h=val;
        int g[]=new int[n];
        g[k-1]=val;
        for(int i=k;i<n;i++){
            if(g[i-1]-1<=0) g[i]=1;
            else g[i]=g[i-1]-1;
            l=l+g[i];
        }
        for(int i=k-2;i>=0;i--){
            if(g[i+1]-1<=0) g[i]=1;
            else g[i]=g[i+1]-1;
            l=l+g[i];
        }
        for(int i=k;i<n;i++){
            g[i]=g[i-1]+1;
            h=h+g[i];
        }
        for(int i=k-2;i>=0;i--){
            g[i]=g[i+1]+1;
            h=h+g[i];
        }
        if(l<=m && m<=h) retVal=1;
        else if(m>h) retVal=2;
        else if(m<l) retVal=3;
        return retVal;
    }
    public static boolean infosysTruckChk(int m,int n,int k,int[] nums){
        int i=0,totK=0;
        while(i<n){
            int ki = infosysTruckSol(m,nums[i]);
            totK+=ki;
            i++;
        }
        return totK>=k;
    }
    public static boolean maxPosGreatCheck(int[] nums,int mid){
        if(mid==0) return true;
        int n=nums.length-1,i=mid-1;
        while(i>=0){
            if(nums[n]<=nums[i]) return false;
            n--;
            i--;
        }
        return true;
    }
    public static int maxChaco(int G){
        if(G%2==0){
            return  (G/2*(G/2 + 1));
        }
        else{
            int V = G/2;
            int Y = G/2 + 1; 
            int G1 = V*(V+1)/2 ; //where V = G//2(rough division.)
            int G2 = Y*(Y+1)/2 ; //where Y = G//2 + 1 
            return (G1 + G2); 
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    public static int binsearchtwoind(int[] nums,int target,boolean isFirstIndx){
        int l=0,r=nums.length-1,m=-1,ans=-1;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]>target) r=m-1;
            else if(nums[m]<target) l=m+1;
            else{
                ans=m;
                if(isFirstIndx) r=m-1;
                else l=m+1;
            }
        }
        return ans;
    }
    public static int binsearchelementindx(int[] nums,int target){
        int l=0,r=nums.length-1,m=0;
        if(target<=nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        if(target==nums[nums.length-1]) return nums.length-1;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]<target) l=m+1;
            else if(nums[m]>target) r=m-1;
            else return m;
        }
        return l;
    }
    public static boolean searchMatrix(int[][] nums,int target){
        int m=nums.length,n=nums[0].length;
        int ol=0,or=m-1,om=-1;
        while(ol<=or){
            om=(ol+or)/2;
            if(target<nums[om][0]) or=om-1;
            else if(target>nums[om][n-1]) ol=om+1;
            else{
                int il=0,ir=n-1,im=-1;
                while(il<=ir){
                    im=(il+ir)/2;
                    if(nums[om][im]>target) ir=im-1;
                    else if(nums[om][im]<target) il=im+1;
                    else return true;
                }
                return false;
            }
        }
       return false;
    }

    public static int countNegatives(int[][] grid){
        int l=0,r=grid[0].length-1,m=-1,res=0;
        for(int[] row:grid){
            while(l<=r){
                m=(l+r)/2;
                if(row[m]<0) r=m-1;
                else l=m+1;
            }
            res=res+grid[0].length-l;
            l=0;
            r=grid[0].length-1;
            m=-1;
        }
        return res;
    }
    public  static int arrangeCoins(int n){
        long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;

      if (curr == n) return (int)k;

      if (n < curr) {
        right = k - 1;
      } else {
        left = k + 1;
      }
    }
    return (int)right;
    }
    public static int[] findRightInterval(int[][] intervals) {
        int l=0,r= intervals.length-1,m=-1;
        int start[][]=new int[r+1][];
        int ans[]=new int[r+1];
        for(int i=0;i<=intervals.length-1;i++){
            start[i]=new int[] {intervals[i][0],i};
        }
        Arrays.sort(start, (a, b) -> Integer.compare(a[0],b[0]));
        for(int i=0;i<=intervals.length-1;i++){
            l=0;
            r= intervals.length-1;
            m=-1;
            while(l<=r){
                m=(l+r)/2;
                if(start[m][0]<intervals[i][1]) l=m+1;
                else if(start[m][0]>=intervals[i][1]) r=m-1;
            }
            if(l<intervals.length) ans[i]=start[l][1];
            else ans[i]=-1;
        }
        return ans;
    }
    public static int findNearIndx(int[] nums,int target){
        int l=0,r=nums.length-1,m=-1;
        while(l<r){
            m=l+(r-l)/2;
            if(nums[m]<target){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }
    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<nums[mid])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(nums[end]>=target && target>nums[mid])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
    public static int singleNonDuplicate(int[] nums) {
        int size = nums.length;
        if(size == 1)
           return nums[0];
        if(nums[0] != nums[1])
           return nums[0];
        if(nums[size - 1] != nums[size - 2])
           return nums[size - 1];
        int start = 1;
        int end = size - 2;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if(mid % 2 == 1 && nums[mid] == nums[mid - 1] ||mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int NthRoot(int N, int A)
    {
        double xPre = Math.random() % 10;
        double eps = 0.001;
        double delX = 2147483647;
        double xK = 0.0;
        while (delX > eps)
        {
            xK = (((N - 1.0) * xPre) +
            ((double)A / Math.pow(xPre, N - 1))) / (double)N;
            delX = Math.abs(xPre-xK);
            xPre = xK;
            if(Math.pow((int)xK,N)==A) return (int)xK;
        }
     return -1;
}
public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long sum=0;
        for(int i:piles) sum+=i;
        int l=(int)(sum/h),r=(int)(sum/(h-n+1)),m=0;
        while(l<=r){
            m=(l+r)/2;
            if(findHour(piles,h,m)) r=m-1;
            else l=m+1;
        }
        return l;
    }
    public static int median(int matrix[][], int R, int C) {
        int l=1;
        int r=(int)1e9;
        int median=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int total=n*m;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int nele=0;
            for(int row=0;row<n;row++)
            {
                nele=nele+findless(matrix,row,mid);
            }
            if(nele>total/2)
            {
                median=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return median;
}
public static char nextGreatestLetter(char[] letters, char target) {
    if((int)target>=(int)letters[letters.length-1] || (int)target<(int)letters[0]) return letters[0];
    int l=0,r=letters.length-1,m;
    while(l<r){
        m=(r+l)/2;
        if((int)letters[m]>(int)target) r=m;
        else if((int)letters[m]<=(int)target) l=m+1;
    }
    return letters[l];
}
public static int findMiddleOccurceArr(int[]nums,int target)
    {
        int l=0;
        int r=nums.length-1;
        int start=0,end=0;
        for(int i=0;i<=1;i++){
            l=0;
        r=nums.length-1;
            while(l <= r) 
        {
            int mid = (l+r)/2;
            if(nums[mid] == target) 
            {
                if(i==0){
                    start = mid;
                r = mid-1;
                }else{
                end = mid;
                l = mid+1;
                }
            }
            else if(nums[mid] > target) 
            {
                 r = mid-1;   
            }
            else 
            {
                l = mid+1 ;
            }
        }
        }
        return (int)(start+end)/2;
    }
     public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       Arrays.sort(arr2);
       ArrayList<Integer>ans=new ArrayList<>();
       for(int i=0;i<arr1.length;i++)
       {
           int count=0;
           int target=arr1[i];
           int lo=0;
           int hi=arr2.length-1;
           while(lo<=hi)
           {
               int mid=(lo)+(hi-lo)/2;
               if(arr2[mid]==target)
               {
                   count=count+mid-lo+1;
                   lo=mid+1;
               }
               else if(arr2[mid]<target)
               {
                   count+=mid-lo+1;
                   lo=mid+1;
               }
               else{
                   if(arr2[mid]>target)
                   {
                       hi=mid-1;
                   }
               }
           }
           ans.add(count);
       }
       return ans;
    }
    public static int minCapability(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int l=min,r=max,m=-1;
        while(l<r){
            m=(l+r)/2;
            if(isPossibleMinCapability(nums,m,k)){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    public static int aggressiveCows(int[] stalls,int k) {
        int n= stalls.length;
        Arrays.sort(stalls);
        int l=1,r=stalls[n-1]-stalls[0],m=-1;
        while(l<=r){
            m=(l+r)/2;
            if(isPossibleCows(stalls,n,k,m)) l=m+1;
            else r=m-1;
        }
        return r;
    }
    public static int findPages(int[] nums,int n,int m){
        int sum=0,res=0;
        if(n<m) return -1;
        for(int i=0;i<n;i++) sum=sum+nums[i];
        int l=nums[n-1],r=sum,mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(isPossiblePage(nums,n,m,mid)){
                res=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return res;
    }
    public static int maxJump(int[] stones) {
        int n= stones.length;
        int left= 1;
        int right= stones[n-1]-stones[0];
        int minJump= right;
        while(left <= right){
            int mid= (left+right)/2;
            boolean possible= isPossibleFrogJump(stones, mid);
            if(possible){
                minJump= mid;
                right= mid-1;                
            }
            else{
                left= mid+1;
            }
        }
        return minJump;
    }
    public static int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int l=0,r=nums[n-1]-nums[0],m=-1;
        while(l<r){
            m=(l+r)/2;
            if(countValidPairs(nums,m)>=p) r=m;
            else l=m+1;
        }
        return l;
    }
    public static boolean deShawMaxPortPossible(int[] nums,int k,int m){
        int total=m*k;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=m) total=total-m;
            else total=total-nums[i];
        }
        return total<=0;
    }
    public static int deShawMaxPort(int[] nums,int k){
        int l=0,r=(int)1e9,ans=0,m=-1;
        while(l<=r){
            m=(l+r)/2;
            if(deShawMaxPortPossible(nums,k,m)){
                ans=m;
                l=m+1;
            }else r=m-1;
        }
        return ans;
    }
    public static int googleMinArr(int[] nums){
        int ans=0,l=0,r=Arrays.stream(nums).max().getAsInt(),m=-1;
        while(l<=r){
            m=(l+r)/2;
            if(googleMinArrPossible(m,nums)){
                ans=m;
                r=m-1;
            }else l=m+1;
        }
        return ans;
    }
    public static int amazonLongSubArr(int[] nums,int k){
        int ans=0,res=0,l=0,m=-1;
        List<Integer> num=Arrays.stream( nums ).boxed().collect( Collectors.toList() );
        ArrayList<Integer> numsList = new ArrayList<Integer>(num);
        HashMap<Integer,ArrayList<Integer>> hash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key = numsList.get(i);
            if(!hash.containsKey(nums[i])) hash.put(nums[i],new ArrayList<Integer>());
            hash.get(key).add(i);
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry : hash.entrySet()){
            ArrayList<Integer> subList = entry.getValue();
            int h = subList.size();
            while(l<=h){
                m=(l+h)/2;
                if(amazonLongPossible(subList,m,k)){
                    res=m;
                    l=m+1;
                }else h=m-1;
            }
            ans=Math.max(ans,res);
        }
        return ans;
    }
    public static int paypalJobSchedule(int n, int m,int k){
        int l=1,h=m,mid=-1,flag=0,ans=-1,check;
        while(l<=h && flag==0){
            mid=(l+h)/2;
            check=paypalJobSchedulePossible(n,m,k,mid);
            if(check==1){
                if(paypalJobSchedulePossible(n,m,k,mid+1)!=1){
                    flag=1;
                    ans=mid;
                }else{
                    l=mid+1;
                }
            }else{
                if(check==2) l=mid+1;
                else h=mid-1;
            }
        }
        return ans;
    }public static int infosysTruckSol(int time,int speed){
        int l=0,h=10000000,optiPacket=0,m=-1;
        while(l<=h){
            m=(l+h)/2;
            int timeTaken = speed*(m*m-m+1);
            if(timeTaken<=time){
                if(timeTaken==time) return m;
                else{
                    optiPacket=Math.max(optiPacket,m);
                    l=m+1;
                }
            }else h=m-1;
        }
        return optiPacket;
    }
    public static int infosysTruckTime(int k,int[] nums){
        int l=1,h=(int)Long.MAX_VALUE,flag=0,m=-1,ans=-1,n=nums.length;
        while(l<=h && flag==0){
            m=(l+h)/2;
            if(infosysTruckChk(m,n,k,nums)){
                if(m==1){
                    flag=1;
                    ans=1;
                }else{
                    if(!infosysTruckChk(m-1,n,k,nums)){
                        ans=m;
                        flag=1;
                    }else h=m-1;
                }
            }else l=m+1;
        }
        return ans;
    }
    public static int maxPosGreat(int[] nums){
        int ans=0,l=1,h=nums.length,m=-1;
        while(l<=h){
            m=(l+h)/2;
            if(maxPosGreatCheck(nums,m) && !maxPosGreatCheck(nums,m+1)) return m;
            else if(maxPosGreatCheck(nums,m) && maxPosGreatCheck(nums,m+1)) l=h+1;
            else h=m-1;
        }
        return ans;
    }
    public static int maxChacoDay(int num){
        int l=0,h=num,m=-1;
        while(l<=h){
            m=(l+h)/2;
            if(maxChaco(m)>num){
                h=m-1;
            }else l=m+1;
        }
        return l;
    }
}