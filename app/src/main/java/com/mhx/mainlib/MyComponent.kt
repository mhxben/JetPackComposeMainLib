package com.mhx.mainlib

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mhx.mainlib.model.OutlinedTextFieldClass


@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    color: Color
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier.fillMaxWidth(),
        shape = shape
    ) {
        PrimaryText(text, color = color)
    }
}

@Composable
fun PrimaryText(text: String,
                color: Color,
                modifier: Modifier = Modifier
) {
    Text(text, fontSize = fontSize1, color = color, modifier = modifier)
}

@Composable
fun SecondText(text: String,
               color: Color,
               modifier: Modifier = Modifier
) {
    Text(text, fontSize = fontSize2, color = color, modifier = modifier)
}

@Composable
fun MainOutlinedTextField(params : OutlinedTextFieldClass) {
    OutlinedTextField(
        value = params.value,
        onValueChange = {params.onValueChange(it)},
        label = { Text(text = params.label) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType),
        visualTransformation = if (params.keyboardType == KeyboardType.Password)
            PasswordVisualTransformation()
        else
            VisualTransformation.None
    )
}

fun Modifier.staticColumn(): Modifier = this
    .fillMaxWidth()
    .padding(16.dp)

fun Modifier.staticRow(): Modifier = this
    .fillMaxWidth()
    .padding(8.dp)
    .height(50.dp)

@Composable
fun SpacerColumn() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpacerRow(){
    Spacer(Modifier.width(16.dp))
}

@Composable
fun ItemCard(text : String ,
             modifier: Modifier = Modifier,
             colorCard: Color ,
             colorText :Color,
             shape: RoundedCornerShape = RoundedCornerShape(8.dp),
             onClick: () -> Unit
){
    Box(contentAlignment = Alignment.Center ,
        modifier = Modifier.background(colorCard).clip(shape)
    ){
        Text(text ,
            modifier.clickable { onClick() },
            fontSize = fontSize1,
            color = colorText
        )
    }
}
