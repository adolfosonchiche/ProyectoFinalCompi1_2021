/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var TextAreaLineNumbersWithCanvas = function()
{
var div = document.createElement('div');
var cssTable = 'padding:0px 0px 0px 0px!important; margin:0px 0px 0px 0px!important; font-size:1px;line-height:0px; width:auto;';
      var cssTd1 = 'border:2px #345 solid; border-right:0px; vertical-align:top; width:1px;';
      var cssTd2 = 'border:1px #345 solid; border-left:0px; vertical-align:top;';
      var cssButton = 'width:120px; height:40px; border:1px solid #333 !important; border-bottom-color: #484!important; color:#DC0C0C; background-color:#222;';
      var cssCanvas = 'border:0px; background-color:#D6D910; margin-top:0px; padding-top:0px;';
      var cssTextArea =  'width:auto;'
                       + 'height:500px;'
                       + 'font-size:14px;'
                       + 'font-family:monospace;'
                       + 'line-height:15px;'
                       + 'font-weight:500;'
                       + 'margin: 0px 0px 0px 0px;'
                       + 'padding: 0px 0px 0px 0px;'
                       + 'resize: both;'
                       + 'color:#000000;'
                       + 'border:0px;'
                       + 'background-color:#FFFF;'
                       + 'white-space:nowrap; overflow:auto;'                    
                       // supported only in opera 12.x
                       + 'scrollbar-arrow-color: #ee8;'
                       + 'scrollbar-base-color: #444;'
                       + 'scrollbar-track-color: #666;'
                       + 'scrollbar-face-color: #444;'
                       + 'scrollbar-3dlight-color: #444;' /* outer light */
                       + 'scrollbar-highlight-color: #666;' /* inner light */
                       + 'scrollbar-darkshadow-color: #444;' /* outer dark */
                       + 'scrollbar-shadow-color: #222;' /* inner dark */
                       ;

      // LAYOUT (table 2 panels)
      var table = document.createElement('table');
          table.setAttribute('cellspacing','0');
          table.setAttribute('cellpadding','0');
          table.setAttribute('style', cssTable);
      var tr = document.createElement('tr');
      var td1 = document.createElement('td');
          td1.setAttribute('style', cssTd1);
      var td2 = document.createElement('td');
          td2.setAttribute('style', cssTd2);

          
          tr.appendChild(td1);
          tr.appendChild(td2);
          table.appendChild(tr);

      // TEXTAREA
      var ta = this.evalnode = document.createElement('textarea');
          ta.setAttribute('cols','115');
          ta.setAttribute('id','area');
          ta.setAttribute('name','area');
          ta.setAttribute('style', cssTextArea);
          //ta.value = this.S.get('eval') || '';  // get previous executed value ;)

      // TEXTAREA NUMBERS (Canvas)
      var canvas = document.createElement('canvas');
          canvas.width = 70;    // must not set width & height in css !!!
          canvas.height = 500;  // must not set width & height in css !!!
          canvas.setAttribute('style', cssCanvas);
          ta.canvasLines = canvas;
          td1.appendChild(canvas);
          td2.appendChild(ta);
          div.appendChild(table);

      // PAINT LINE NUMBERS
      ta.paintLineNumbers = function()
      {
        try
        {
        var canvas = this.canvasLines;
        if (canvas.height != this.clientHeight) canvas.height = this.clientHeight; // on resize
        var ctx = canvas.getContext("2d");
        ctx.fillStyle = "#338217"; //color del margen donde va el numero de linea
        ctx.fillRect(0, 0, 60, this.scrollHeight+1);
        ctx.fillStyle = "#232323";
        ctx.font = "14px monospace"; // NOTICE: must match TextArea font-size(12px) and lineheight(15) !!!
        var startIndex = Math.floor(this.scrollTop / 15,0);
        var endIndex = startIndex + Math.ceil(this.clientHeight / 15,0);
        for (var i = startIndex; i < endIndex; i++)
        {
          var ph = 10 - this.scrollTop + (i*15);
          var text = ''+(1+i);  // line number
          ctx.fillText(text,40-(text.length*6),ph);
        }
        }
        catch(e){ alert(e); }
      };
      ta.onscroll     = function(ev){ this.paintLineNumbers(); };
      ta.onmousedown  = function(ev){ this.mouseisdown = true; }
      ta.onmouseup    = function(ev){ this.mouseisdown=false; this.paintLineNumbers(); };
      ta.onmousemove  = function(ev){ if (this.mouseisdown) this.paintLineNumbers(); };

	document.body.appendChild(div);
    // make sure it's painted
	ta.paintLineNumbers();
    return ta;
};
var ta = TextAreaLineNumbersWithCanvas();
//aqui escribe en el editor de texto
	//ta.value = TextAreaLineNumbersWithCanvas.toString();
function escribir() 
{ 
const input = document.getElementById('file');
const editor = document.getElementById('area');
  if (input.files.length > 0) {
    readFile(input.files[0]);
  }
function readFile(file) {
  const reader = new FileReader();
  reader.onload = function() {
    editor.value= reader.result; 
    //editor.value='aaaaaa';
  }
  reader.readAsText(file);
}
};


