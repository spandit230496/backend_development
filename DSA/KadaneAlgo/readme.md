🧠 When Should YOU Think of Kadane?

If you see:

"contiguous"
"maximum sum"
"subarray"
"continuous window"

👉 Immediately think: Kadane

⚡ Simple Intuition (Golden Line)

“If the running sum becomes negative, drop it — it will only reduce future profit.”


🔹 Core Idea

Instead of checking all subarrays (which is slow), Kadane’s algorithm decides at each index:

👉 “Should I extend the current subarray or start a new one from here?”



🟢 Core Problem (Must Do)
1. Maximum Subarray (#53)

👉 Solve on LeetCode

🟡 Medium Level
2. Maximum Sum Circular Subarray (#918)

👉 https://leetcode.com/problems/maximum-sum-circular-subarray/

3. Maximum Product Subarray (#152)

👉 https://leetcode.com/problems/maximum-product-subarray/

4. Maximum Absolute Sum of Any Subarray (#1749)

👉 https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

5. Maximum Subarray Sum With One Deletion (#1186)

👉 https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

🔴 Hard Level
6. K Concatenation Maximum Sum (#1191)

👉 https://leetcode.com/problems/k-concatenation-maximum-sum/

🔥 Bonus (Very Important Pattern Extension)
7. Maximum Sum Rectangle (2D Kadane)

👉 https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix/

🧠 Tip (Important)

The Maximum Subarray problem (#53) is the foundation of Kadane’s Algorithm, which solves the problem in O(n) time by maintaining current and global maximums
