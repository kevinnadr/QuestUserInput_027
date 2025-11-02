package com.example.questuserinput_027

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormsDataDiri(
    modifier: Modifier,
    name: String
) {
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textRT by remember { mutableStateOf(value = "") }
    var textRW by remember { mutableStateOf(value = "") }
    var textKotaAsal by remember { mutableStateOf(value = "") }
    var textTglLahir by remember { mutableStateOf(value = "") }
    var textUmur by remember { mutableStateOf(value = "") }
    var isChecked by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }



    val datePickerState = rememberDatePickerState()
    var showDatePickerDialog by remember { mutableStateOf(false) }


    fun Long.toFormattedDate(): String {
        val date = Date(this)
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return format.format(date)
    }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.background),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Form Registrasi",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(start = 12.dp, top = 80.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            fontSize = 34.sp,
            color = Color.White,
        )

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 140.dp, bottom = 140.dp)
            .background(
                color = Color.White.copy(alpha = 0.5f),
                shape = RoundedCornerShape(size = 30.dp)
            )



    )
    {
        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            OutlinedTextField(
                value = textNama,
                onValueChange = { textNama = it },
                label = { Text("Nama Lengkap") },
                modifier = Modifier.width(width = 350.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )


            OutlinedTextField(
                value = textKotaAsal,
                onValueChange = { textKotaAsal = it },
                label = { Text("Kota Asal") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            // Baris untuk Tanggal Lahir, RT, dan RW
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val interactionSource = remember { MutableInteractionSource() }
                if (interactionSource.collectIsPressedAsState().value) {
                    showDatePickerDialog = true
                }


                OutlinedTextField(
                    value = textTglLahir,
                    onValueChange = { },
                    label = { Text("Tanggal Lahir") },
                    modifier = Modifier.weight(1.6f),
                    singleLine = true,
                    readOnly = true,
                    interactionSource = interactionSource,
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Pilih Tanggal"
                        )
                    }
                )
}