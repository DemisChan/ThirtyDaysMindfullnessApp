package com.project.thirtydaysapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.thirtydaysapp.data.Activity
import com.project.thirtydaysapp.data.ActivityRepository
import com.project.thirtydaysapp.ui.theme.ThirtyDaysAppTheme
import com.project.thirtydaysapp.ui.theme.Typography

@Composable
fun ActivityItem(activityDay: Activity, modifier: Modifier = Modifier) {

    var expanded by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.surface
        else MaterialTheme.colorScheme.onPrimary, label = "Color Animation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                shape = RoundedCornerShape(15.dp)
            ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color)
                .padding(16.dp)
                .height(200.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                ActivityInfo(
                    title = activityDay.day,
                    heading = activityDay.heading,
                    modifier = Modifier
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(0.5f))
                ActivityItemButton(
                    expanded = expanded,
                    modifier = Modifier.weight(1f),
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                ActivityContent(
                    content = activityDay.content,
                    modifier = modifier
                )
            }
            Box(
                modifier = modifier
                    .padding(top = 2.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                ActivityImage(
                    image = activityDay.imageResourceId,
                    modifier = modifier

                )
            }
        }

    }
}

@Composable
fun ActivityInfo(
    @StringRes title: Int,
    @StringRes heading: Int,
    modifier: Modifier = Modifier,

    ) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = title),
            style = Typography.titleLarge,
        )
        Text(
            text = stringResource(id = heading),
            style = MaterialTheme.typography.displayLarge,
        )
    }
}


@Composable
fun ActivityContent(
    @StringRes content: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = content),
        style = MaterialTheme.typography.bodyLarge,
    )

}

@Composable
fun ActivityItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ActivityImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier.clip(MaterialTheme.shapes.small),
        painter = painterResource(id = image),
        contentDescription = "image of the day",
        contentScale = ContentScale.Inside,
        )

}

@Composable
fun ActivityList(
    activityList: List<Activity>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = contentPadding) {
        items(activityList) {
            ActivityItem(activityDay = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityInfoPreview() {
    ActivityInfo(
        title = ActivityRepository.activities[0].day,
        heading = ActivityRepository.activities[0].heading,
    )
}

@Preview(showBackground = true)
@Composable
fun ActivityImagePreview() {
    ActivityImage(image = R.drawable.day_1)

}

@Preview(showBackground = true)
@Composable
fun ActivityItemPreview() {
    ThirtyDaysAppTheme {
        ActivityItem(activityDay = ActivityRepository.activities[1])
    }

}

