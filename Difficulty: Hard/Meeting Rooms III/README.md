<h2><a href="https://www.geeksforgeeks.org/problems/meeting-rooms-iii/1">Meeting Rooms III</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given an integer <strong>n</strong> representing the number of rooms numbered from <strong>0</strong> to <strong>n - 1</strong>. Additionally, given a 2D integer array <strong>meetings[][]</strong> where meetings[i] = [start<sub>i</sub>, end<sub>i</sub>] indicates that a meeting is scheduled during the half-closed time interval [start<sub>i</sub>, end<sub>i</sub>]. All start<sub>i</sub> values are unique.</span></p><p><span style="font-size: 14pt;">Meeting Allocation<strong> </strong>Rules:</span></p><ul><li><span style="font-size: 14pt;">When a meeting starts, assign it to the available room with the smallest number.</span></li><li><span style="font-size: 14pt;">If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.</span></li><li><span style="font-size: 14pt;">When a room becomes free, assign it to the delayed meeting with the earliest original start time.</span></li></ul><p><span style="font-size: 14pt;">Return the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.</span></p><p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p><pre><span style="font-size: 14pt;"><strong>Input: </strong>n = 2, meetings[][] = [[0, 6], [2, 3], [3, 7], [4, 8], [6, 8]]<strong>
Output:</strong> 1<strong>
Explanation: <br></strong>Time 0: Both rooms available. [0, 6] starts in room 0.
Time 2: Room 0 busy until 6. Room 1 available. [2, 3] starts in room 1.
Time 3: Room 1 frees up. [3, 7] starts in room 1.
Time 4: Both rooms busy. [4, 8] is delayed.
Time 6: Room 0 frees up. Delayed [4, 8] starts in room 0 [6, 10).
Time 6: [6, 8] arrives but both rooms busy. It’s delayed.
Time 7: Room 1 frees up. Delayed [6, 8] starts in room 1 [7, 9).</span><br><span style="font-size: 14pt;">Meeting counts: [2, 3]</span></pre><pre><span style="font-size: 14pt;"><strong>Input: </strong>n = 4, meetings[][] = [[0, 8], [1, 4], [3, 4], [2, 3]<strong>
Output: </strong>2<strong>
Explanation:<br></strong>Time 0: All rooms available. [0, 8] starts in room 0.
Time 1: Room 0 busy until 8. Rooms 1, 2, 3 available. [1, 4] starts in room 1.
Time 2: Rooms 0 and 1 busy. Rooms 2, 3 available. [2, 3] starts in room 2.
Time 3: Room 2 frees up. [3, 4] starts in room 2.
Meeting counts: [1, 1, 2, 0]</span></pre></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Heap</code>&nbsp;<code>Priority Queue</code>&nbsp;