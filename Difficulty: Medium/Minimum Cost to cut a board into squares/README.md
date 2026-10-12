<h2><a href="https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1">Minimum Cost to cut a board into squares</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given a board of dimensions <strong>n × m</strong> that needs to be divided into 1 × 1 squares. The cost of making cuts is given in two arrays:</span></p>
<ul>
<li><span style="font-size: 14pt;"><strong>x[] </strong>represents costs of making different vertical cuts from 1 to m-1.</span></li>
<li><span style="font-size: 14pt;"><strong>y[] </strong>represents costs of making different horizontal cuts from 1 to n-1.</span></li>
<li><span style="font-size: 14pt;">The cost of a vertical cut is multiplied by the current number of horizontal segments.</span></li>
<li><span style="font-size: 14pt;">The cost of a horizontal cut is multiplied by the current number of vertical segments.</span></li>
</ul>
<p><span style="font-size: 14pt;">Find the minimum total cost required to divide the entire board into 1 × 1 squares.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:<br></strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> n = 3, m = 3, x[] = [2, 1], y[] = [4, 3]
<strong>Output: </strong>16
<strong>Explanation:<br></strong> <img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/932767/Web/Other/blobid1_1786023755.webp" width="619" height="253"></span><span style="font-size: 18px;"><br>So, the total cost = 4 + 3 + 6 + 3  = 16.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input:</strong> n = 2, m = 3, x[] = [2, 1], y[] = [3]<br></span><span style="font-size: 18px;"><strong style="font-size: 18px;">Output: </strong><span style="font-size: 18px;">9<span style="font-size: 18px;"><br><strong>Explanation:<br></strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/932767/Web/Other/blobid0_1786023754.webp" width="638" height="281"></span></span><span style="font-size: 18px;"><strong style="font-size: 18px;"><br></strong><span style="font-size: 18px;">So, the total cost = 3 + 3 + 3 = 9.</span></span></span></pre>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>NPCI</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Greedy</code>&nbsp;