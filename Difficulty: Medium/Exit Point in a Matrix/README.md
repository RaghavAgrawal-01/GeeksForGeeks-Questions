<h2><a href="https://www.geeksforgeeks.org/problems/exit-point-in-a-matrix0905/1">Exit Point in a Matrix</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given a matrix mat[][] of size <strong>n</strong> × <strong>m </strong>consisting of <strong>0</strong>s and <strong>1</strong>s. You start at the top-left cell (0, 0). Initially, you are positioned at (0, 0) and facing right (toward (0, 1)). Before each move, apply the rules based on the value of the current cell:</span></p>
<ul>
<li><span style="font-size: 18px;">If the current cell contains 0, continue moving in the same direction.</span></li>
<li><span style="font-size: 18px;">If the current cell contains 1, change your direction to the right (clockwise turn), and update the cell value to 0.</span></li>
</ul>
<p><span style="font-size: 18px;">You continue this process until you move outside the boundaries of the matrix. Determine the coordinates (row and column index) of the cell from which you exit the matrix.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>mat[][] = [[0, 1, 0],
               [0, 1, 1], <br>               [0, 0, 0]]
<strong>Output: </strong>[1, 0]
<strong>Explanation: <br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/927810/Web/Other/blobid0_1778220093.png" width="220" height="194"><br></strong>From the image we can see that, enter the matrix at (0, 0) <br>-&gt; then move towards (0, 1) -&gt;  1 is encountered <br>-&gt; turn right towards (1, 1)  -&gt; again 1 is encountered <br>-&gt; turn right again towards (1, 0) <br>-&gt; now, the boundary of matrix will be crossed. Hence, exit point reached at [1, 0].</span>
</pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input: </strong><span style="font-size: 18px;">mat[][] = [[1, 1],<br>                 [0, 1]]
</span><strong style="font-size: 18px;">Output: </strong><span style="font-size: 18px;">[1, 0]<br></span><strong style="font-size: 18px;">Explanation:<br><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/705235/Web/Other/blobid0_1781514646.webp" width="132" height="139"><br></strong><span style="font-size: 18px;">Enter the matrix at (0, 0) facing right
-&gt; 1 is encountered at (0, 0)
-&gt; turn right and move to (1, 0)
-&gt; 0 is encountered at (1, 0)
-&gt; continue moving down and cross the matrix boundary. Hence, the exit point is reached at [1, 0].</span></span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ n, m ≤ 100</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Samsung</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Matrix</code>&nbsp;