package solutions;

import Datastructure.ListNode;
import Datastructure.TreeNode;
import Datastructure.Utils;
import solutions.ArraysAndNumbersProblems.PoisonousPlants;
import solutions.ArraysAndNumbersProblems.ThreeCLosestSum;
import solutions.ArraysAndNumbersProblems.ThreeSum;
import solutions.ArraysAndNumbersProblems.TwoSum;
import solutions.DPProblems.LongestPalindrome;
import solutions.DPProblems.MinimumXORSumOfTwoArrays;
import solutions.GeneralProblems.RevealCardsInIncreasingOrder;
import solutions.GeneralProblems.RomanNumber;
import solutions.GeneralProblems.RomanToInt;
import solutions.LinkedListProblems.ReverseNodesKGroup;
import solutions.LinkedListProblems.SwapNodesInPairs;
import solutions.LinkedListProblems.addTwoNumbersLinkedList;
import solutions.SortingAndSearchingAndSelctionProblems.MedianOfTwoSortedArrays;
import solutions.StringsAndPatternsProblems.GenerateParentheses;
import solutions.StringsAndPatternsProblems.SubstringWithConcatenationOfAllWords;
import solutions.StringsAndPatternsProblems.ZigZagConversion;
import solutions.TreeProblems.SameTree;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int len = 4;
    static final char[] c = {'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /* Usually don't bother yourself by looking here, it's just for testing purpose (Yeah, people before JUnit lives here) */
    public static void main(String[] args) {
        System.out.println("By laws = "+byLaws()+", by MontiCarlo = "+byMontiCarlo());
    }
    private static long byMontiCarlo(){
        Set<String> set = new HashSet<>();
        set.add("");
        int ans = (int) set.stream().flatMap(e -> {
            ArrayList<String> arr = new ArrayList<>();
            for (char c1 : c)
                for (char c2 : c)
                    for (char c3 : c)
                        for (char c4 : c)
                            {
                                    char[] s = {c1, c2, c3, c4};
                                    arr.add(new String(s));
                                }
            return arr.stream();
        }).filter(Main::check).count();
        return ans;
    }
    private static long byLaws(){
        long res = 1;
        int past = 1;
        int mkam = 1;
        for(int i=0; i<len/2; i++) {
            res *= 26;
            res *= 10;
            past *= (len-i);
            mkam *= (i+1);
        }
        return res * (past/mkam);
    }
    private static boolean check(String e) {
        int nc = 0 , cc = 0;
        for(int i=0; i<len; i++){
            if(e.charAt(i) >= 'a' && e.charAt(i) <= 'z')
                ++cc;
            else
                ++nc;
        }
        return nc == len/2 && cc == len/2;
    }

    private static void sameTree() {
        SameTree s = new SameTree();
        TreeNode r1 = new TreeNode(2);
        r1.right = new TreeNode(4);

        TreeNode r2 = new TreeNode(2,new TreeNode(3),new TreeNode(4));
        s.isSameTree(r1,r2);
    }

    private static  void miniXORSsum(){
        MinimumXORSumOfTwoArrays m = new MinimumXORSumOfTwoArrays();
        int[] a1 = {1,0,3};
        int[] a2 = {5,3,4};
        m.minimumXORSum(a1,a2);
    }
    private static void substringConc(){
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        String str = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] arr = {"fooo","barr","wing","ding","wing"};
        List<Integer> result = s.findSubstring(str,arr);
        for(Integer i : result){
            System.out.println(i);
        }
    }
    private static void romanToInt(){
        RomanToInt r = new RomanToInt();
        String[] strings = {"III","IV","VI","IX","LVIII","MCMXCIV"};
        for(String s : strings)
        System.out.println(s+" : "+r.romanToInt(s));
    }
    private static void swapKGroup(){
        int[] arr = {1, 2, 3, 4,5};
        ReverseNodesKGroup r = new ReverseNodesKGroup();
        ListNode head = ListNode.makeList(1, 2, 3, 4,5);
        ListNode kth = r.reverseKGroup(head,1);
        ListNode.printList(kth);
    }
    private static void swapNodesSovler(){
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode head = ListNode.makeList(1, 2, 3, 4,5,6);
        ListNode newHead =s.swapPairs(head);
        ListNode.printList(newHead);
    }
    private static void generateParenthesesSolver(){
        GenerateParentheses gp = new GenerateParentheses();
        var l = gp.generateParenthesis(3);
        for(var s : l ){
            System.out.print(s+", ");
        }
    }

    private static void threeClosestSumSolver(){
        ThreeCLosestSum tcs = new ThreeCLosestSum();
        int[] arr = {-1,2,1,-4};

        int result = tcs.threeSumClosest(arr ,1 );
        System.out.print(result);
    }

    private static void poisonousPlantsSolver(){
        List<Integer> list;
        try {
            list = Utils.readArrayFromFile("C:\\Users\\zezo\\IdeaProjects\\LeetCodeProblems\\src\\solutions\\tt.txt");
            System.out.print(PoisonousPlants.poisonousPlants(list));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void threeSumSolver(){
        ThreeSum threeSums = new ThreeSum();
       var t= threeSums.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
       for(var tt : t){
           for(var ttt :tt){
               System.out.print(ttt+" ");
           }
           System.out.print('\n');
       }
    }
    private static void revealCardSol(){
        RevealCardsInIncreasingOrder r = new RevealCardsInIncreasingOrder();
        int[] arr = {17,13,11,2,3,5,7};
        int[] arr2 = {1,1000};
        int[] sol =r.deckRevealedIncreasing(arr);
        System.out.print(Arrays.toString(sol));

    }
    private static void romanianSolver(){
        RomanNumber romanNumber = new RomanNumber();
        System.out.println(romanNumber.intToRoman(1000));
    }
    private static void zigzagSolver(){
        ZigZagConversion zigZagConversion= new ZigZagConversion();
       System.out.println(zigZagConversion.convert("PAYPALISHIRING",3));
    }
    private static void palindromSolver(){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
    private static void twoSumSolver(){
        TwoSum twoSum = new TwoSum();
        int [] n = {3,2,4};

        twoSum.twoSum(n,6);
    }
    static void medianOfTwoArraysSolver(){
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(median.findMedianSortedArrays(nums1,nums2));
    }



    static void addTwoNumbersSolver(){
        addTwoNumbersLinkedList solver = new addTwoNumbersLinkedList();

        /*ListNode l1 = new ListNode(2);
        l1.next  = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
*/
      /*  ListNode l1 =new ListNode(0);
        ListNode l2 =new ListNode(0);*/
        int[] numbers = {9,9,9,9};
        ListNode l1 = new ListNode(numbers[0]);
        ListNode node_ref = l1;
        for(int i=1;i<numbers.length;i++){
            node_ref.next = new ListNode(numbers[i]);
            node_ref = node_ref.next;
        }

        int[] numbers2 = {9,9,9,9,9,9,9};
        ListNode l2 = new ListNode(numbers2[0]);
        node_ref = l2;
        for(int i=1;i<numbers2.length;i++){
            node_ref.next = new ListNode(numbers2[i]);
            node_ref = node_ref.next;
        }

        ListNode sum  = solver.addTwoNumbers(l1,l2);
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(sum);
    }
}
//////////////////////
