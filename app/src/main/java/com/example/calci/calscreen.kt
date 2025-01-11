package com.example.calci

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calci.ui.theme.Cyan
import com.example.calci.ui.theme.skin


val calbtnlist = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "-",
    "1", "2", "3", "+",
    "AC", "0", ".", "=",
)

@Composable
fun calscreen(viewModel: calculatorViewModel) {
    val equationText =viewModel.equationText.observeAsState()
    val resultText =viewModel.resultText.observeAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = equationText.value?:"",
                modifier = Modifier.padding(bottom = 5.dp, end = 27.dp),
                fontSize = 30.sp, fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = resultText.value?:"0",
                fontSize = 70.sp,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(bottom = 20.dp, end = 20.dp),
                fontWeight = FontWeight.Bold, maxLines = 2
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            ) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .padding(bottom = 20.dp, top = 5.dp,start=8.dp, end = 8.dp),
                    columns = GridCells.Fixed(4), verticalArrangement = Arrangement.spacedBy(-10.dp)
                ) {
                    items(calbtnlist) {
                        calculatorbtn(it, onclick = {
                            viewModel.onBtnClick(it)
                        })
                    }

                }
            }
        }
    }
}

@Composable
fun calculatorbtn(btn: String,onclick : ()->Unit) {
    Box(
        modifier = Modifier.padding(top = 12.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onclick,
            modifier = Modifier
                .size(85.dp)
                .clip(shape = RectangleShape), shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            if (btn == "C" || btn == "(" || btn == ")") {
                Text(text = btn, color = Cyan, fontSize = 30.sp)
            } else if (btn == "AC") {
                Text(text = btn, color = Cyan, fontSize = 28.sp)
            } else if (btn == "÷" || btn == "x" || btn == "-" || btn == "+" || btn == "=") {
                Text(text = btn, color = skin, fontSize = 30.sp)
            } else {
                Text(text = btn, color = MaterialTheme.colorScheme.tertiary, fontSize = 30.sp)
            }
        }
    }
}

