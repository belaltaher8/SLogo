# SLogo

## Description
SLogo is a recreation of Logo - a popular children's coding language. Logo is a user-friendly, interpreted language, designed with a "low floor, high ceiling"; in other words, the designers of Logo intended for the language to allow novice programmers to get started quickly writing programs but also wanted the language to be powerful and extensive for more advanced users.

SLogo uses the MVC paradigm to allow the user to interact with the "turtles" (they can actually become anything you'd like if you upload a new image) on a per expression basis.

![SLogo IDE](https://raw.githubusercontent.com/belaltaher8/SLogo/master/SLogoIDE.PNG)

## Commands

<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"> 
  <meta name="authors" content="Robert Duvall and Daniel Rubinstein" />

</head>
<body>
  <div class="mainBody">
<p>While the command names below are given in all capital letters, SLogo is not case sensitive. Note that any values used as parameters to a command may be the result of calling any of the commands below or a value stored in a variable. Thus all commands return a double value as described below. Also, commands can be formatted over any number of lines, including multiple commands on the same line, but they must be separated by one or more spaces.</p>
<h4 align="left">Basic Syntax</h4>
<TABLE BORDER="1">
<TR>
  <TH>Token</TH>
  <TH>Syntax</TH>
  <TH>Semantics</TH>
  <TH>Examples</TH>
</TR>
<TR>
  <TD><B>Constant</B></TD>
  <TD><DIV align="center"><code>[0-9].[0-9]</code></DIV></TD>
  <TD>any real valued number<br />
      note, to avoid potential ambiguity in parsing there should not be a space between the negative sign and the value
  </TD>
  <TD><DIV align="right">
        <code>50</code><BR />
        <code>-1.3</code>
      </DIV>
  </TD>
</TR>
<TR>
  <TD><B>Variable</B></TD>
  <TD><DIV align="center"><code>:[a-z or A-Z]</code></DIV></TD>
  <TD>any word preceded by a colon, :<br />
    note, if a variable name is used that has not previously been given a value, return a default value (i.e., 0)</TD>
  <TD><DIV align=right>
    <code>:distance</code><BR />
    <code>:side</code></DIV>
  </TD>
</TR>
<tr>
  <td><b>Command</b></td>
  <td><div align="center"><code>[a-z or A-Z]</code></div></td>
  <td>any word can be a command-name<br />
    note, all commands return a numeric value<br />
    note, built-in commands are given below and  user-defined commands cannot reuse those names</td>
  <td><div align="right"> <code>forward</code><br />
    <code>fd</code></div></td>
</tr>
<TR>
  <TD><strong>List</strong></TD>
  <TD><div align="center"><code>[ <br />
    ]</code></div></TD>
  <TD>these brackets enclose a list of zero or more commands or variables<br />
    note, to make parsing easier, these will always be separated from other tokens by spaces</TD>
  <TD><div align="right"><code>[ fd 50 rt 90 ]</code></div></TD>
</TR>
<TR>
  <TD><strong>Comment</strong></TD>
  <TD><div align="center"><code>#</code></div></TD>
  <TD> Ignore any lines that are empty, i.e., only zero or more spaces, and lines that begin with the comment character, &quot;#&quot;.</TD>
  <TD><div align="right"><code># a comment</code><br /><code>#fd 50</code></div></TD>
</TR>
</TABLE>
<H4>Turtle Commands (for both a single and multiple turtles)</H4>
<TABLE BORDER="1">
<TR>
  <TH>Name(s)</TH>
  <TH>Description</TH>
</TR>
<TR>
  <TD>FORWARD <em>pixels</em><br>
    FD <em>pixels</em></TD>
  <TD>moves  turtle forward in its current heading by <em>pixels</em> distance<br />
    returns the value of <em>pixels</em></TD>
</TR>
<TR>
  <TD>BACK <em>pixels</em><br>
    BK <em>pixels</em></TD>
  <TD>moves  turtle backward in its current heading by <em>pixels</em> distance<br />
    returns the value of <em>pixels</em></TD>
</TR>
<TR>
  <TD>LEFT <em>degrees</em><br>
    LT <em>degrees</em></TD>
  <TD>turns  turtle counterclockwise by <em>degrees</em> angle<br />
    returns the value of <em>degrees</em></TD>
</TR>
<TR>
  <TD>RIGHT <em>degrees</em><br>
    RT <em>degrees</em></TD>
  <TD>turns  turtle clockwise by <em>degrees</em> angle<br />
    returns the value of <em>degrees</em></TD>
</TR>
<tr>
  <td>SETHEADING <em>degrees</em><br />
    SETH <em>degrees</em></td>
  <td>turns  turtle to an absolute heading<br />
    returns number of degrees moved </td>
</tr>
<TR>
  <TD>TOWARDS <em>x</em> <em>y </em></TD>
  <TD>turns  turtle to face the point (<em>x</em>, <em>y</em>), where (0, 0) is the center of the screen<br />
    returns the number of degrees  turtle turned</TD>
</TR>
<tr>
  <td>SETXY <em>x</em> <em>y</em><br />
    GOTO <em>x</em> <em>y</em></td>
  <td>moves  turtle to an absolute screen position, where (0, 0) is the center of the screen<br />
    returns the distance turtle  moved </td>
</tr>
<TR>
  <TD>PENDOWN<br>PD</TD>
  <TD>puts  pen down such that when the turtle moves, it leaves a trail<br />
    returns 1</TD>
</TR>
<TR>
  <TD>PENUP<br>PU</TD>
  <TD>puts  pen up such that when the turtle moves, it does not leave a trail<br />
    returns 0</TD>
</TR>
<TR>
  <TD>SHOWTURTLE<br>ST</TD>
  <TD>makes  turtle visible<br />
    returns 1</TD>
</TR>
<TR>
  <TD>HIDETURTLE<br>HT</TD>
  <TD>makes  turtle invisible<br />
    returns 0</TD>
</TR>
<TR>
  <TD>HOME</TD>
  <TD>moves  turtle to the center of the screen (0 0)<br />
    returns the distance turtle moved</TD>
</TR>
<TR>
  <TD>CLEARSCREEN<br>CS</TD>
  <TD>erases  turtle's trails and sends it to the home position<br />
    returns the distance turtle moved</TD>
</TR>
</TABLE>
<h4>Display Commands</h4>
<p>Note, for commands below that receive/return an index number, that index should refer to a list of  graphical items (like an image or color) whose items are clearly available in the GUI with their number or order apparent (so the user knows how to refer  to them within a command). Also, it would be helpful to populate each list with some initial default choices for the user.</p>
<TABLE BORDER="1">
<TR>
  <TH>Command</TH>
  <th>Description</th>
  </TR>
<TR>
  <TD><code>SETBACKGROUND</code> <em>index</em><br>
      <code>SETBG</code> <em>index</em>
  </TD>
  <td>sets background color of screen to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<TR>
  <TD><code>SETPENCOLOR</code> <em>index</em><br />
      <code>SETPC</code> <em>index</em>
  </TD>
  <td>sets color of the pen to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<TR>
  <TD><code>SETPENSIZE</code> <em>pixels</em><br />
      <code>SETPS</code> <em>pixels</em>
  </TD>
  <td>sets size of the pen to be <em>pixels</em> thickness<br />
    returns given <em>pixels</em></td>
  </TR>
<TR>
  <TD><code>SETSHAPE</code> <em>index</em><br />
      <code>SETSH</code> <em>index</em>
  </TD>
  <td>sets shape of turtle to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<tr>
  <td><code>SETPALETTE</code> <em>index</em> <em>r</em> <em>g</em> <em>b</em></td>
  <td>sets color corresponding at given <em>index</em> to given <em>r</em> <em>g</em> <em>b</em> color values<br />
    returns given <em>index</em><br />
    note, color component values are nonnegative integers less than 256 specifying an amount of red, green, and blue </td>
  </tr>
<tr>
  <td><code>PENCOLOR<br />
  </code><code>PC</code></td>
  <td>returns  turtle's current color index</td>
  </tr>
<tr>
  <td><code>SHAPE</code><br />
    <code>SH</code><em></em></td>
  <td>returns   turtle's current shape index</td>
  </tr>
</TABLE>
<h4>Multiple Turtle Commands</h4>
<TABLE BORDER="1">
<TR>
  <TH>Command</TH>
  <th>Description</th>
  </TR>
<TR>
  <TD>ID</TD>
  <td>returns  current active turtle's ID number<br />
    ID values typically start at 1 and increase by 1 with each new turtle created<br />
    note, there is  technically only one &quot;active turtle&quot; at any given time since each command is run once for each active turtle, i.e., this value can always be used to identify the current turtle running the command</td>
  </TR>
<tr>
  <td>TURTLES<br />
    <br /></td>
  <td>returns  number of turtles created so far</td>
</tr>
<TR>
  <TD><code>TELL</code> <code>[</code> <em>turtle(s)</em> <code>]</code></TD>
  <td>sets <em>turtles</em> that will follow commands hereafter<br />
    returns last value in <em>turtles</em> list<em><br />
      </em>note, if turtle has not previously existed, it is created and placed at the home location<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
  </TR>
<tr>
  <td><code>ASK</code> <code>[</code> <em>turtle(s)</em> <code>]</code> <br />    
    <code>[</code><em>&nbsp;&nbsp;command(s)</em> <code>]</code></td>
  <td>only the <i>turtles</i> given in first list all run <em>commands</em> given in the second list<em><br />
    </em>returns result of last command run by the last turtle<br />
    note, after commands are run,  currently active list of turtles returns to that set by the last TELL command (or default active turtle if TELL never given)<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
</tr>
<TR>
  <TD><code>ASKWITH</code> <code>[</code> <em>condition</em> <code>]<br />
  </code> <code>[</code><em>&nbsp;&nbsp;command(s)</em> <code>]</code></TD>
  <td>tell <i>turtles</i> matching  given <em>condition</em> to run <em>commands</em> given in the second list<em><br />
    </em>returns result of last command run<br />
    note, after commands are run,  currently active list of turtles returns to that set by the last TELL command (or default active turtle if TELL never given)<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
  </TR>
</TABLE>
<h4>Display Commands</h4>
<p>Note, for commands below that receive/return an index number, that index should refer to a list of  graphical items (like an image or color) whose items are clearly available in the GUI with their number or order apparent (so the user knows how to refer  to them within a command). Also, it would be helpful to populate each list with some initial default choices for the user.</p>
<TABLE BORDER="1">
<TR>
  <TH>Command</TH>
  <th>Description</th>
  </TR>
<TR>
  <TD><code>SETBACKGROUND</code> <em>index</em><br>
      <code>SETBG</code> <em>index</em>
  </TD>
  <td>sets background color of screen to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<TR>
  <TD><code>SETPENCOLOR</code> <em>index</em><br />
      <code>SETPC</code> <em>index</em>
  </TD>
  <td>sets color of the pen to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<TR>
  <TD><code>SETPENSIZE</code> <em>pixels</em><br />
      <code>SETPS</code> <em>pixels</em>
  </TD>
  <td>sets size of the pen to be <em>pixels</em> thickness<br />
    returns given <em>pixels</em></td>
  </TR>
<TR>
  <TD><code>SETSHAPE</code> <em>index</em><br />
      <code>SETSH</code> <em>index</em>
  </TD>
  <td>sets shape of turtle to that represented by <em>index</em><br />
    returns given <em>index</em></td>
  </TR>
<tr>
  <td><code>SETPALETTE</code> <em>index</em> <em>r</em> <em>g</em> <em>b</em></td>
  <td>sets color corresponding at given <em>index</em> to given <em>r</em> <em>g</em> <em>b</em> color values<br />
    returns given <em>index</em><br />
    note, color component values are nonnegative integers less than 256 specifying an amount of red, green, and blue </td>
  </tr>
<tr>
  <td><code>PENCOLOR<br />
  </code><code>PC</code></td>
  <td>returns  turtle's current color index</td>
  </tr>
<tr>
  <td><code>SHAPE</code><br />
    <code>SH</code><em></em></td>
  <td>returns   turtle's current shape index</td>
  </tr>
</TABLE>
<h4>Multiple Turtle Commands</h4>
<TABLE BORDER="1">
<TR>
  <TH>Command</TH>
  <th>Description</th>
  </TR>
<TR>
  <TD>ID</TD>
  <td>returns  current active turtle's ID number<br />
    ID values typically start at 1 and increase by 1 with each new turtle created<br />
    note, there is  technically only one &quot;active turtle&quot; at any given time since each command is run once for each active turtle, i.e., this value can always be used to identify the current turtle running the command</td>
  </TR>
<tr>
  <td>TURTLES<br />
    <br /></td>
  <td>returns  number of turtles created so far</td>
</tr>
<TR>
  <TD><code>TELL</code> <code>[</code> <em>turtle(s)</em> <code>]</code></TD>
  <td>sets <em>turtles</em> that will follow commands hereafter<br />
    returns last value in <em>turtles</em> list<em><br />
      </em>note, if turtle has not previously existed, it is created and placed at the home location<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
  </TR>
<tr>
  <td><code>ASK</code> <code>[</code> <em>turtle(s)</em> <code>]</code> <br />    
    <code>[</code><em>&nbsp;&nbsp;command(s)</em> <code>]</code></td>
  <td>only the <i>turtles</i> given in first list all run <em>commands</em> given in the second list<em><br />
    </em>returns result of last command run by the last turtle<br />
    note, after commands are run,  currently active list of turtles returns to that set by the last TELL command (or default active turtle if TELL never given)<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
</tr>
<TR>
  <TD><code>ASKWITH</code> <code>[</code> <em>condition</em> <code>]<br />
  </code> <code>[</code><em>&nbsp;&nbsp;command(s)</em> <code>]</code></TD>
  <td>tell <i>turtles</i> matching  given <em>condition</em> to run <em>commands</em> given in the second list<em><br />
    </em>returns result of last command run<br />
    note, after commands are run,  currently active list of turtles returns to that set by the last TELL command (or default active turtle if TELL never given)<br />
    note, if more than one turtle is active, commands run return value associated with the last active turtle </td>
  </TR>
</TABLE>
<H4>Turtle Queries</H4>
<TABLE BORDER="1">
<TR>
  <TH>Name</TH>
  <TH>Description</TH>
</TR>
<TR>
  <TD>XCOR</TD>
  <TD>returns the turtle's X coordinate  from the center of the screen</TD>
</TR>
<TR>
  <TD>YCOR</TD>
  <TD>returns the turtle's Y coordinate  from the center of the screen</TD>
</TR>
<tr>
  <td>HEADING</td>
  <td>returns the turtle's heading in degrees</td>
</tr>
<tr>
  <td>PENDOWN?<br />
    PENDOWNP</td>
  <td>returns 1 if turtle's pen is down, 0 if it is up</td>
</tr>
<tr>
  <td>SHOWING?<br />
    SHOWINGP</td>
  <td>returns 1 if turtle is showing, 0 if it is hiding</td>
</tr>
</TABLE>
<H4>Math Operations</H4>
<TABLE BORDER="1">
<TR>
  <TH>Name</TH>
  <TH>Description</TH>
</TR>
<TR>
  <TD>SUM <em>expr1</em> <em>expr2</em><br />
    + <em>expr1</em> <em>expr2</em></TD>
  <TD>returns sum of the values of <i>expr1</i> and <i>expr2</i></TD>
</TR>
<TR>
  <TD>DIFFERENCE <em>expr1</em> <em>expr2</em><br />
    - <em>expr1</em> <em>expr2</em></TD>
  <TD>returns difference of the values of  <i>expr1</i> and <i>expr2</i></TD>
</TR>
<TR>
  <TD>PRODUCT <em>expr1</em> <em>expr2</em><br />
    * <em>expr1</em> <em>expr2</em></TD>
  <TD>returns product of the values of  <i></i> <i>expr1</i> and <i>expr2</i></TD>
</TR>
<TR>
  <TD>QUOTIENT <em>expr1</em> <em>expr2</em><br />
    / <em>expr1</em> <em>expr2</em></TD>
  <TD>returns  quotient of the values of  <i></i> <i>expr1</i> and <i>expr2</i></TD>
</TR>
<TR>
  <TD>REMAINDER <em>expr1</em> <em>expr2</em><br />
    % <em>expr1</em> <em>expr2</em></TD>
  <TD>returns  remainder on dividing the values of  <i></i> <i> expr1</i> by <i>expr2</i></TD>
</TR>
<TR>
  <TD>MINUS <em>expr</em><br />
    ~ <em>expr</em></TD>
  <TD>returns negative of the values of  <i></i> <i>expr</i></TD>
</TR>
<TR>
  <TD>RANDOM <em>max</em></TD>
  <TD>returns random non-negative number strictly less than <em>max</em></TD>
</TR>
<TR>
  <TD>
  SIN <em>degrees</em></TD>
  <TD>
  returns sine of <em>degrees</em></TD>
<TR>
<TR>
  <TD>
  COS <em>degrees</em></TD>
  <TD>
  return cosine of <em>degrees</em></TD>
<TR>
<TR>
  <TD>
  TAN <em>degrees</em></TD>
  <TD>
  returns tangent of <em>degrees</em></TD>
<TR>
<TR>
  <TD>
  ATAN <em>degrees</em></TD>
  <TD>
  returns arctangent of <em>degrees</em></TD>
</TR>
<TR>
  <TD>
  LOG <em>expr</em></TD>
  <TD>
  returns  natural log of  <em>expr</em></TD>
</TR>
<TR>
  <TD>
  POW <em>base exponent</em></TD>
  <TD>
  returns  <em>base</em> raised to the power of the <em>exponent</em></TD>
</TR>
<TR>
  <TD>PI</TD>
  <TD>Reports the number Pi</TD>
</TR>
</TABLE>
<H4>Boolean Operations</H4>
<TABLE BORDER="1">
<TR>
  <TH>Name</TH>
  <TH>Description</TH>
</TR>
<TR>
  <TD>LESS? <em>expr1</em> <em>expr2</em><br />
    LESSP <em>expr1</em> <em>expr2</em></TD>
  <TD>returns 1  if the value of  <i></i> <em>expr1</em> is strictly less than the value of  <i></i> <em></em> <em>expr2</em>, otherwise 0</TD>
</TR>
<TR>
  <TD>GREATER? <em>expr1</em> <em>expr2</em><br />
    GREATERP <em>expr1</em> <em>expr2</em></TD>
  <TD>returns 1 if the value of  <i></i> <em></em> <em>expr1</em> is strictly greater than the value of  <i></i> <em></em> <em>expr2</em>,  otherwise 0</TD>
</TR>
<TR>
  <TD>EQUAL? <em>expr1</em> <em>expr2</em><br />
    EQUALP <em>expr1</em> <em>expr2</em></TD>
  <TD>returns 1 if the value of  <i></i> <em></em> <em>expr1 </em>and the value of  <i></i> <em></em> <em>expr2</em> are equal, otherwise 0</TD>
</TR>
<TR>
  <TD>NOTEQUAL? <em>expr1</em> <em>expr2</em><br />
    NOTEQUALP <em>expr1</em> <em>expr2</em> &nbsp;</TD>
  <TD>returns 1 if the value of  <i></i> <em></em> <em>expr1</em> and   the value of  <i></i> <em></em><em>expr2</em> are not equal, otherwise 0</TD>
</TR>
<TR>
  <TD>AND <em>test1</em> <em>test2</em></TD>
  <TD>returns 1  if <i>test1</i> and <i>test2</i> are non-zero, otherwise 0</TD>
</TR>
<TR>
  <TD>OR <em>test1</em> <em>test2</em></TD>
  <TD>returns 1 if <i>test1</i> or <i>test2</i> are non-zero, otherwise 0</TD>
</TR>
<TR>
  <TD>NOT <em>test</em></TD>
  <TD>returns 1 if <i>test</i> is 0 and 0 if <i>test</i> is non-zero</TD>
</TR>
</TABLE>
<H4>Variables,  Control Structures, and User-Defined Commands</H4>
<TABLE BORDER="1">
<TR>
  <TH>Name</TH>
  <TH>Description</TH>
</TR>
<TR>
  <TD>MAKE <em>variable</em> <em>expr</em><br />
      SET <em>variable</em> <em>expr</em></TD>
  <TD>assigns the value of  <i></i> <em></em> <em>expr</em> to <em>variable</em>, creating the variable if necessary<em><br />
  </em>returns <em>expr</em></TD>
</TR>
<TR>
  <TD>REPEAT <em>expr</em> [ <em>command(s)</em> ]</TD>
  <TD>runs  <em>command(s</em>) given in the  list the value of  <i></i> <em></em> <em>expr</em> number of times<br />
    returns the value of the final command executed  (or 0 if no commands are executed)<br />    
    note, the value of the current iteration, starting at 1, is automatically assigned to the variable <em>:repcount</em> so that it can be accessed by the <em>command(s)</em></TD>
</TR>
<tr>
  <td>DOTIMES [ <em>variable</em> <em>limit</em> ]<br />
    [ <em>command(s)</em> ]</td>
  <td>runs  <em>command(s)</em> for each value specified in the range, i.e., from (1 - <em>limit</em>) inclusive <br />
    returns the value of the final command executed  (or 0 if no commands are executed)<br />
    note, <em>variable</em> is assigned to each succeeding value so that it can be accessed by the <em>command(s)</em></td>
</tr>
<tr>
  <td>FOR [ <em>variable</em> <em>start end increment</em> ]<br />
    [ <em>command(s)</em> ]</td>
  <td>runs  <em>command(s)</em> for each value specified in the range, i.e., from (<var>start</var> - <em>end</em>), going by <em>increment</em><br />
    returns the value of the final command executed  (or 0 if no commands are executed)<br />
    note, <em>variable</em> is assigned to each succeeding value so that it can be accessed by the <em>command(s)</em></td>
</tr>
<TR>
  <TD>IF <em>expr</em> [ <em>command(s)</em> ]</TD>
  <TD>if <em>expr</em> is not 0, runs the <em>command(s)</em> given in the  list<br />
    returns the value of the final command executed ( (or 0 if no commands are executed)</TD>
</TR>
<tr>
  <td>IFELSE <em>expr</em> <br />
    [ <em>trueCommand(s)</em> ] <br />
    [ <em>falseCommand(s)</em> ]</td>
  <td>if <i> expr</i> is not 0, runs the <em>trueCommands</em> given in the first  list, otherwise runs the <em>falseCommands</em> given in the second  list<br />
    returns the value of the final command executed  (or 0 if no commands are executed)</td>
</tr>
<tr>
  <td>TO <em>commandName<br />
    </em> [ <em>variable(s)</em> ]<br />
    [ <em>command(s)</em> ]</td>
  <td>assigns <em>command(s)</em> given in the second list to <em>commandName</em> using <em>parameters</em> given in first list as variables<br />
    when <em>commandName</em> is used later in a program,  any given values are assigned to variables that can be accessed when  the command list is run and  the value of the final command executed is returned (or 0 if no commands are executed)<br />
    returns 1 if command is successfully defined, otherwise 0</td>
</tr>
</TABLE>
</div>
</div>
</body>
</html>


## Logistics

### Team Members
* Alex Boss
* Hari Rajan
* Belal Taher
* Daniel Rubinstein

### Time Taken

Date started: Feb 16

Date finished: Mar 10

Hours spent: 200+




