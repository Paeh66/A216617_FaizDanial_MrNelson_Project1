package com.example.a216617_mrnelson_project1

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.LinearProgressIndicator
import com.example.a216617_mrnelson_project1.ui.theme.A216617_MrNelson_Project1Theme

@Composable
fun CityReportScreen(
    messages: List<ReportMessage>,
    onGoForm: () -> Unit,
    onGoList: () -> Unit,
    onGoStats: () -> Unit,
    onGoProfile: () -> Unit
) {

    val screenBackground = MaterialTheme.colorScheme.background
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = screenBackground)
            .verticalScroll(scrollState)
    ) {

        // HEADER
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(top = 40.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, null, tint = Color.White)
                }

                IconButton(onClick = onGoProfile) {
                    Icon(Icons.Default.AccountCircle, null, tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.city),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.Black, CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("CityReport", fontSize = 26.sp, color = MaterialTheme.colorScheme.onPrimary)
            Text("Report community issues", fontSize = 14.sp, color = MaterialTheme.colorScheme.onPrimary)
            Text(
                "SDG 11: Sustainable Cities & Communities",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ACTION BUTTONS (same as your Lab 3 UI)
        ActionItemRow(Icons.Default.LocationOn, "Report", "Submit a new community report details...")

        ActionItemRow(Icons.Default.QuestionAnswer, "Ask", "Ask questions about city services") {
            onGoForm()
        }

        ActionItemRow(Icons.Default.Lightbulb, "Suggest", "Provide suggestions for improvements")

        ActionItemRow(Icons.Default.ThumbUp, "Feedback", "Give feedback on the system")

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.onBackground, // Swaps color based on theme!
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                "${messages.size} New reports created",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Text("Report Status",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatusButton("In Progress", messages.size, Color(0xFFFFA726), Modifier.weight(1f)) {
                    onGoList()
                }
                StatusButton("Under Review", 0, Color(0xFF42A5F5), Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatusButton("Completed", 0, Color(0xFF66BB6A), Modifier.weight(1f)){
                    onGoStats()
                }
                StatusButton("Rejected", 0, Color(0xFFEF5350), Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun ActionItemRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
            .clickable { expanded = !expanded }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .padding(16.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onClick() },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // elevation
            ) {
                Text(
                    text = "GO TO ${title.uppercase()}",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}
@Composable
fun StatusButton(title: String, count: Int, color: Color, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.width(6.dp).height(24.dp).background(color, RoundedCornerShape(3.dp)))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = title, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = count.toString(), fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = ">", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}


@Composable
fun FormScreen(onBack: () -> Unit, onSubmit: (String,String, String, String) -> Unit) {
    var selectedAgency by remember { mutableStateOf("Select Agency") }
    var expanded by remember { mutableStateOf(false) }

    // STATE APIs
    var title by remember { mutableStateOf("") }
    var report by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    val agencies = listOf("DBKL", "PDRM", "TNB", "MPKJ")
    val scrollState = rememberScrollState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(vertical = 16.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Text("❮", fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("New Feedback", fontSize = 18.sp, color = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.weight(1f))
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // 🔷 AGENCY DROPDOWN FIX
                Text("Agency Target", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true } // 👈 Click modifier on the Box instead
                ) {
                    TextField(
                        value = selectedAgency,
                        onValueChange = {},
                        readOnly = true,
                        // enabled = false disables typing & allows the Box's click to trigger!
                        enabled = false,
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = { Text("▼", color = Color.Gray) },
                        // These colors ensure it doesn't look grayed out/disabled
                        colors = androidx.compose.material3.TextFieldDefaults.colors(
                            disabledTextColor = Color.Black,
                            disabledContainerColor = Color.White,
                            disabledTrailingIconColor = Color.Gray,
                            disabledPlaceholderColor = Color.Gray,
                            disabledIndicatorColor = Color.Transparent // Removes the bottom line if wanted
                        )
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        agencies.forEach { agency ->
                            DropdownMenuItem(
                                text = { Text(agency) },
                                onClick = {
                                    selectedAgency = agency
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text("Subject Title", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Enter subject title") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Question Description", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = report,
                    onValueChange = { report = it },
                    modifier = Modifier.fillMaxWidth().height(100.dp),
                    placeholder = { Text("Describe your question...") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Question Location", color = Color.Gray, fontSize = 14.sp)
                TextField(
                    value = location,
                    onValueChange = { location = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Enter location") },
                    // Ikon Lokasi Profesional
                    trailingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Gray) }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Attachments (Max 50 MB)", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Ikon Kamera, Video, dan Fail Profesional
                    IconButton(onClick = {}) { Icon(Icons.Default.PhotoCamera, contentDescription = null, modifier = Modifier.size(32.dp), tint = MaterialTheme.colorScheme.surfaceContainerLow) }
                    IconButton(onClick = {}) { Icon(Icons.Default.Videocam, contentDescription = null, modifier = Modifier.size(32.dp), tint = MaterialTheme.colorScheme.surfaceContainerLow) }
                    IconButton(onClick = {}) { Icon(Icons.Default.AttachFile, contentDescription = null, modifier = Modifier.size(32.dp), tint = MaterialTheme.colorScheme.surfaceContainerLow) }
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {
                        if (title.isNotBlank() && report.isNotBlank()) {
                            onSubmit(selectedAgency,title, report, location)
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Submit", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}


@Composable
fun MessageListScreen(
    messages: List<ReportMessage>,
    onBack: () -> Unit,
    onItemClick: (Int) -> Unit
) {

    val scrollState = rememberScrollState()
    // Holds the current search
    var searchQuery by remember { mutableStateOf("") }

    // list based on the search query
    val filteredMessages = messages.filter { message ->
        message.agency.contains(searchQuery, ignoreCase = true) ||
                message.title.contains(searchQuery, ignoreCase = true) ||
                message.issue.contains(searchQuery, ignoreCase = true) ||
                message.location.contains(searchQuery, ignoreCase = true)
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(vertical = 16.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Text("❮", fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("My Reported Issues", fontSize = 18.sp, color = Color.White, modifier = Modifier.weight(1f))
                }
            }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {

                // SEARCH TEXTFIELD
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it }, // Triggers dynamic UI update!
                    placeholder = { Text("Search title, issue or location...") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.padding(start = 8.dp), tint = Color.Black)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                // Ikon Close Profesional
                                Icon(Icons.Default.Close, contentDescription = "Clear")
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,      // Input text stays black
                        unfocusedTextColor = Color.Black,    // Input text stays black
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(24.dp)
                )

                if (filteredMessages.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = if (messages.isEmpty()) "No reports yet" else "No matching results",
                            color = Color.Gray
                        )
                    }
                } else {
                    // Loop through the FILTERED list instead of the raw one
                    filteredMessages.forEachIndexed { index,report ->
                        val originalIndex = messages.indexOf(report)
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(2.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                                .clickable { onItemClick(originalIndex) }
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(text = report.title, fontSize = 16.sp, color = Color.Black)
                                    Box(
                                        modifier = Modifier
                                            .background(Color(0xFF1E3A8A), RoundedCornerShape(4.dp))
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Text(text = "IN PROGRESS", fontSize = 10.sp, color = Color.White)
                                    }
                                }

                                Text(
                                    text = "Agency: ${report.agency}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.padding(top = 4.dp)
                                )

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = report.issue, fontSize = 14.sp, color = Color.Gray)

                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "📍 Location: ${report.location}", fontSize = 12.sp, color = Color(0xFF2E56A8))

                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "ASK.9399${index}", fontSize = 11.sp, color = Color.Gray)
                                    Text(text = "06/04/2026 4:20 PM", fontSize = 11.sp, color = Color.Gray)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(report: ReportMessage, onBack: () -> Unit) {

    val scrollState = rememberScrollState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {

            // HEADER
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(vertical = 16.dp, horizontal = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack) {
                        Text("❮", fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Report Details",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }

            // CONTENT
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text("Assigned Agency", fontSize = 14.sp, color = Color.Gray)
                Text(report.agency, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(16.dp))

                Text("Title", fontSize = 14.sp, color = Color.Gray)
                Text(report.title, fontSize = 18.sp, color = MaterialTheme.colorScheme.surfaceContainerLow)

                Spacer(modifier = Modifier.height(16.dp))

                Text("Description", fontSize = 14.sp, color = Color.Gray)
                Text(report.issue, fontSize = 16.sp, color = MaterialTheme.colorScheme.surfaceContainerLow)

                Spacer(modifier = Modifier.height(16.dp))

                Text("Location", fontSize = 14.sp, color = Color.Gray)
                Text(report.location, fontSize = 16.sp, color = Color(0xFF2E56A8))
            }
        }
    }
}

@Composable
fun StatsScreen(viewModel: ReportViewModel, onBack: () -> Unit) {
    val categories = listOf("Report", "Ask", "Suggest", "Feedback")
    val agencyStats = viewModel.getAgencyStats()

    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary).padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack) { Text("❮", color = Color.White) }
                    Text("Impact Dashboard", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).verticalScroll(rememberScrollState())) {

            Text("Community Activity Summary", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Spacer(modifier = Modifier.height(12.dp))

            // Grid of 4 categories (The Calculation Part)
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                categories.chunked(2).forEach { rowItems ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        rowItems.forEach { type ->
                            Card(
                                modifier = Modifier.weight(1f),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(type, style = MaterialTheme.typography.bodySmall)
                                    Text("${viewModel.getCountByType(type)}", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("Agency Distribution", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            // Agency Breakdown (Processing Part 2)
            if (agencyStats.isEmpty()) {
                Text("No data available yet.", color = Color.Gray, fontSize = 14.sp)
            } else {
                agencyStats.forEach { (agency, count) ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(agency)
                        Text("$count", fontWeight = FontWeight.Bold)
                    }
                    LinearProgressIndicator(
                        progress = count.toFloat() / viewModel.messages.size,
                        modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp))
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(onBack: () -> Unit) {

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(top = 40.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Text("❮", fontSize = 20.sp, color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Profile Information",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.isagi),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "Personal Information",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ProfileItem(
                        label = "Full Name",
                        value = "MUHAMMAD FAIZ DANIAL BIN ABDUL AZIZ"
                    )

                    ProfileItem(
                        label = "MyKad",
                        value = "040624100293"
                    )

                    ProfileItem(
                        label = "Email",
                        value = "muhdfaizdanial68@gmail.com"
                    )

                    ProfileItem(
                        label = "Phone Number",
                        value = "0132560147"
                    )

                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "Login Information",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Username",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    TextField(
                        value = "Faizd68",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "New Password",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Enter new password") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Confirm Password",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Confirm password") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(
                            text = "Save",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = label,
            fontSize = 13.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider(color = Color.LightGray)

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CityReportScreenPreview() {
    A216617_MrNelson_Project1Theme {
        CityReportApp()
    }
}