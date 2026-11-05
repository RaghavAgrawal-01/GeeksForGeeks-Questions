<h2><a href="https://www.geeksforgeeks.org/problems/prime-list--170646/1">Prime List</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given a linked list, replace all the values with the nearest prime number. </span></p>
<ul>
<li><span style="font-size: 14pt;">If more than one prime number exists at an equal distance, choose the smallest one. </span></li>
<li><span style="font-size: 14pt;">Return the head of the modified linked list.</span></li>
</ul>
<p><span style="font-size: 14pt;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>head[] =<strong> [</strong>2, 6, 10]
<strong>Output: [</strong>2, 5, 11]<br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/933096/Web/Other/blobid0_1787143630.png" alt=""><br><strong>Explanation: </strong>The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so, 5 will be chosen. The nearest prime of 10 is 11.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>head[] =<strong> [</strong>1, 15, 20]
<strong>Output: [</strong>2, 13, 19]<br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/933096/Web/Other/blobid1_1787143630.png" alt=""><br><strong>Explanation: </strong>The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13 will be chosen. The nearest prime of 20 is 19.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 &lt;= no. of Nodes &lt;= 10<sup>4</sup><br>1 &lt;= node.val &lt;= 10<sup>4</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Linked List</code>&nbsp;<code>Mathematics</code>&nbsp;<code>Prime Number</code>&nbsp;