import java.util.*;

public class main {

    public static void main(String[] arrgs) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        //String[] sss = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        //System.out.println(isHappy(1));
        ;
        int[] aa = {0, 0, 0, 0};
        threeSum(aa);
        //System.out.println(canConstruct("a", "b"));
    }

    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        if (nums.length == 2) {
            return nums[0];
        }

        while (true) {
            slow = nums[slow];

            fast = nums[nums[fast]];

            System.out.println(slow + "," + fast);

            if (slow == fast) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    slow = nums[slow];
                    fast = nums[fast];

                    System.out.println("2:" + slow + "," + fast);

                }
                return nums[slow];

            }

//            slow++;
//            if(slow>=length){
//                slow = slow-length;
//
//            }
//
//
//
//            fast = fast+2;
//            if(fast>=length){
//                fast = fast - length;
//            }


        }
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println((long)(mid*mid));
            if (mid <= x / mid) {
                ans = mid;
                //System.out.println(ans);
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }

        return ans;


    }


    private static boolean needAdd = false;

    public static int[] plusOne(int[] digits) {
        int length = digits.length;

        plus(digits, length - 1);

        if (needAdd) {
            int[] ans = new int[length + 1];
            for (int i = 0; i < length; i++) {
                ans[i + 1] = digits[i];
                ans[0] = 1;
            }
            return ans;
        } else {
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                ans[i] = digits[i];
            }
            return ans;
        }


    }

    public static void plus(int[] digits, int position) {
        digits[position] = digits[position] + 1;
        if (digits[position] == 10) {
            digits[position] = 0;
            if (position == 0) {
                needAdd = true;
            } else {
                plus(digits, position - 1);
            }

        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        ans1.add(1);
        ans.add(ans1);
        if (numRows == 1) {
            return ans;
        }
        List<Integer> ans2 = new ArrayList<>();
        ans2.add(1);
        ans2.add(1);
        ans.add(ans2);
        if (numRows == 2) {
            return ans;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> ansRow = new ArrayList<>();
            List<Integer> lastRow = ans.get(i - 1);
            ansRow.add(1);
            for (int j = 0; j < i - 1; j++) {
                ansRow.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            ansRow.add(1);
            ans.add(ansRow);
        }

        return ans;
    }

    public static int maxProfit(int[] prices) {
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            //System.out.println("dp1 =" +dp1);
            //System.out.println("dp2 =" +dp2);
        }
        return Math.max(dp0, dp2);

//        int max = 0;
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i+1;j<prices.length;j++){
//                if(prices[j]-prices[i]>max){
//                    max = prices[j]-prices[i];
//                }
//            }
//        }
//        return max;
    }

    public static int maxProfit2(int[] prices) {
//        int dp0 = 0;
//        int dp1 = -prices[0];
//        int dp2 = 0;
//        for(int i=1;i<prices.length;i++){
//            dp1 = Math.max(dp1,dp0-prices[i]);
//            dp2 = Math.max(dp2,dp1 + prices[i]);
//            //System.out.println("dp1 =" +dp1);
//            //System.out.println("dp2 =" +dp2);
//        }
//        return Math.max(dp0,dp2);

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;
    }


    public static List<Integer> getRow_outTime(int rowIndex) {
        int size = rowIndex + 1;
        List<Integer> ans1 = new ArrayList<>();
        ans1.add(1);
        if (rowIndex == 0) {
            return ans1;
        }
        List<Integer> ans2 = new ArrayList<>();
        ans2.add(1);
        ans2.add(1);
        if (rowIndex == 1) {
            return ans2;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex % 2 == 1) { //奇数行
            for (int i = 1; i < (size + 1) / 2; i++) {
                ans.add(lastRow(i - 1, rowIndex - 1) + lastRow(i, rowIndex - 1));
            }
            for (int i = 0; i < (size + 1) / 2 - 1; i++) {
                ans.add(ans.get((size + 1) / 2 - 1 - i));
            }
        } else {
            for (int i = 1; i < (size) / 2 + 1; i++) {
                ans.add(lastRow(i - 1, rowIndex - 1) + lastRow(i, rowIndex - 1));
            }
            for (int i = 0; i < (size) / 2 - 1; i++) {
                ans.add(ans.get((size) / 2 - 1 - i));
            }
        }
        ans.add(1);
        return ans;
    }

    public static int lastRow(int position, int row) {
        int right = 1;
        int left = 1;
        if (row > 1) {
            if (position == 0) {
                return 1;
            } else {
                left = lastRow(position - 1, row - 1);
            }
            if (position == row) {
                return 1;
            } else {
                right = lastRow(position, row - 1);
            }
        }
        if (row == 1) {
            return 1;
        }
        return right + left;
    }


    public static List<Integer> getRow(int rowIndex) {
        int[][] temp = new int[rowIndex + 1][rowIndex + 1];
        temp[0][0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            temp[i][0] = 1;
            temp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i - 1][j - 1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            ans.add(temp[rowIndex][i]);
        }
        return ans;
    }

    public static String convertToTitle(int columnNumber) {
        String stringBuffer = "";
        while (columnNumber != 0) {
            int a = columnNumber % 26;
            if (a == 0) a = 26;
            char aa = (char) (a + 64);
            columnNumber = columnNumber / 26;
            if (a == 26) columnNumber = columnNumber - 1;
            stringBuffer = stringBuffer + aa;
        }
        String ans = "";
        for (int i = 0; i < stringBuffer.length(); i++) {
            ans = ans + stringBuffer.toCharArray()[stringBuffer.length() - i - 1];
        }

        return ans;
    }

    public static int titleToNumber(String columnTitle) {
        int size = 1;
        int ans = 0;
        for (int i = columnTitle.length(); i > 0; i--) {
            char a = columnTitle.toCharArray()[i - 1];
            int aa = ((int) a) - 64;
            ans = ans + aa * size;
            size = size * 26;
        }
        return ans;

    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> loaclEmail = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String emailStr = emails[i];
            loaclEmail.add(normalizeEmail(emailStr));

        }

        return loaclEmail.size();
    }

    public static String normalizeEmail(String email) {
        String[] strings = email.split("@");
        String address = strings[0];
        address = address.replace(".", "");
        if (address.contains("+")) {
            address = address.substring(0, address.indexOf("+"));
        }
        System.out.println(address + "@" + strings[1]);
        return address + "@" + strings[1];

    }

    public static int[] sortArrayByParityII(int[] nums) {

        //int[] ans = new int[nums.length];
//        int jiPosition = 0;
//        int ouPosition = 0;
//
//        for(int i=0;i<nums.length;i++){
//            //偶数
//            if(i % 2 ==0){
//                for(int j=ouPosition;j<nums.length;j++){
//                    if(nums[j] % 2 ==0){
//                        ans[i]=nums[j];
//                        ouPosition = j+1;
//                        break;
//                    }
//                }
//            }
//            else{
//                //奇数
//                for(int j = jiPosition;j<nums.length;j++){
//                    if(nums[j] % 2!= 0 ){
//                        ans[i] = nums[j];
//                        jiPosition = j+1;
//                        break;
//                    }
//                }
//            }
//
//        }
        int jiNum = 1;
        int temp = 0;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 != 0) {

                while (nums[jiNum] % 2 != 0) {
                    jiNum = jiNum + 2;
                }
                temp = nums[jiNum];
                nums[jiNum] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int maxX = n;
        int maxY = n;
        int minX = 0;
        int minY = 0;
        int i = 0;
        int j = 0;
        int nowNumber = 0;
        boolean right = true;
        boolean left = false;
        boolean up = false;
        boolean down = false;
        while (nowNumber != n * n) {
            nowNumber++;

            if (right) {
                if (j < maxY) {
                    ans[i][j] = nowNumber;
                    System.out.println("i= " + i + ",j=" + j + ",num=" + nowNumber + " right");
                    j++;
                } else {
                    nowNumber--;
                    right = false;
                    down = true;
                    i++;
                    j--;
                }

            } else if (down) {
                if (i < maxX) {
                    ans[i][j] = nowNumber;
                    //System.out.println("i= " + i + ",j=" + j + ",num=" + nowNumber + " down");
                    i++;
                } else {
                    nowNumber--;
                    down = false;
                    left = true;
                    j--;
                    i--;
                }
            } else if (left) {
                if (minY <= j) {
                    ans[i][j] = nowNumber;
                    //System.out.println("i= " + i + ",j=" + j + ",num=" + nowNumber + " left");
                    j--;

                } else {
                    nowNumber--;
                    left = false;
                    up = true;
                    i--;
                    j++;
                    minX++;
                }
            } else if (up) {
                if (minX <= i) {
                    ans[i][j] = nowNumber;
                    //System.out.println("i= " + i + ",j=" + j + ",num=" + nowNumber + " up");
                    i--;
                } else {
                    up = false;
                    right = true;
                    j++;
                    i++;
                    nowNumber--;
                    maxX--;
                    maxY--;
                    minY++;
                }
            }

        }
        return ans;


    }

    public static int search(int[] nums, int target) {
        int max = nums.length;
        int min = 0;
        int mid = 0;
        int ans = -1;
        if (max == 1) {
            if (nums[0] == target) {
                return 0;
            } else return -1;
        }
        if (target < nums[0]) {
            return -1;
        }
        if (target > nums[nums.length - 1]) {
            return -1;
        }
        for (int i = 0; i < (nums.length / 2 + 1); i++) {
            mid = (max + min) / 2;
            if (nums[mid] > target) {
                max = mid - 1;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            // System.out.println("right++ "+nums[right]);
            right++;
            // System.out.println("sum++ "+sum);
            while (sum >= target) {
                sum = sum - nums[left];
                //System.out.println("left++ "+nums[left]);
                min = Math.min(min, right - left);
                left++;
                //System.out.println("sum++ "+sum);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int temp = 0;
        while (left < right) {
            if (nums[left] != val) {
                left++;
            } else {
                while (nums[right] == val && right > 0) {
                    right--;
                }
                if (right > left) {
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    right--;
                }

            }
        }
        int ans = 0;
        boolean reomved = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                ans = i;
                reomved = true;
                break;
            }
        }
        if (!reomved) {
            ans = nums.length;
        }
//        System.out.println("left "+left+" ,right "+right);

        return ans;
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 1;
        int temp = 0;
//        boolean needChange =true;
//        while (right<nums.length){
//            if(nums[left]!=0){
//                left++;
//                if(left>=nums.length-1){
//                    right = nums.length;
//                }
//            }
//            else {
//                right = left+1;
//                while (nums[right]==0 ){
//                    right++;
//                    if(right>nums.length-1){
//                        needChange = false;
//                        break;
//                    }
//                }
//                if(needChange){
//                    temp = nums[left];
//                    nums[left] = nums[right];
//                    nums[right] = temp;
//                }
//
//            }
//        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        //头结点移除
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode ans = head;
        while (ans.next != null) {
            if (ans.next.val == val) {
                ans.next = ans.next.next;
            } else {
                ans = ans.next;
            }

        }
        return head;
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            System.out.println("area =" + area + ", left =" + left + ", right =" + right);

        }
        System.out.println(max);

        return max;

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }

    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        } else {
            int[] nums = new int[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (int i = 0; i < sChars.length; i++) {
                char sc = sChars[i];
                nums[sc - 97]++;
                char st = tChars[i];
                nums[st - 97]--;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    return false;
                }
            }
        }
        return true;

    }

    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> p1 = new HashSet();
//        HashSet<Integer> p2 = new HashSet();
//        for (int i = 0; i < nums1.length; i++) {
//            p1.add(nums1[i]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (p1.contains(nums2[i])) p2.add(nums2[i]);
//        }
//        int[] ans =new int[p2.size()];
//        int ansSize = 0;
//        for(int ansNum:p2){
//            ans[ansSize] = ansNum;
//            ansSize++;
//        }
//        return ans;
        int left = 0;
        int right = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                set.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            ans[i] = val;
            i++;
        }
        return ans;
    }

    public static boolean isHappy(int n) {
//        HashSet<Integer> set = new HashSet<>();
//        int i = n;
//        while (true) {
//            i = getnum(i);
//            if (i == 1) {
//                return true;
//            } else {
//                if (set.contains(i)) {
//                    return false;
//                } else {
//                    set.add(i);
//                }
//            }
//        }
        int left = n;
        int right = getnum(n);
        if (left == right) {
            if (left == 1) {
                return true;
            } else {
                return false;
            }
        }
        while (right != left) {
            left = getnum(left);
            right = getnum(getnum(right));
            if (left == right) {
                if (left == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public static int getnum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += (num % 10) * (num % 10);
            num = num / 10;
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                ans[0] = i;
                break;
            } else {
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < ans[0]; i++) {
            if (nums[i] == target - nums[ans[0]]) {
                ans[1] = i;
                break;
            }
        }

        return ans;

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ranChars = ransomNote.toCharArray();
        char[] magaChars = magazine.toCharArray();
        if (ranChars.length > magaChars.length) {
            return false;
        }
        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < magaChars.length; i++) {
            char mChar = magaChars[i];
            if (chars.containsKey(mChar)) {
                int size = chars.get(mChar).intValue() + 1;
                chars.put(mChar, size);
            } else {
                chars.put(mChar, 1);
            }
            if (i < ranChars.length) {
                char rChar = ranChars[i];
                if (chars.containsKey(rChar)) {
                    int size = chars.get(rChar).intValue() - 1;
                    chars.put(rChar, size);
                } else {
                    chars.put(rChar, -1);
                }
            }
        }
//        for (char mChar : magaChars) {
//            if (chars.containsKey(mChar)) {
//                int size = chars.get(mChar).intValue() + 1;
//                chars.put(mChar, size);
//            } else {
//                chars.put(mChar, 1);
//            }
//        }
//        for (char mChar : ranChars) {
//            if (chars.containsKey(mChar)) {
//                int size = chars.get(mChar).intValue() - 1;
//                if (size < 0) {
//                    return false;
//                } else {
//                    chars.put(mChar, size);
//                }
//            } else {
//                return false;
//            }
//        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() < 0) {
                return false;
            }
        }
        return true;

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        if (nums.length < 3) {
            return ans;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                List<Integer> ansList = new ArrayList<>();
                int rightNum = nums[right];
                int leftNum = nums[left];
                if (nums[i] + leftNum + rightNum == 0) {
                    ansList.add(nums[i]);
                    ansList.add(leftNum);
                    ansList.add(rightNum);
                    ans.add(ansList);
                    left++;
                    while (leftNum == nums[left] && left < right) {
                        left++;
                    }
                    right--;
                    while (rightNum == nums[right] && left < right) {
                        right--;
                    }
                } else if (nums[i] + leftNum + rightNum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
//        for (List<Integer> aaa : ans) {
//            System.out.println(aaa.get(0) + "," + aaa.get(1) + "," + aaa.get(2));
//        }
        return ans;
    }

}
