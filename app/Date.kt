
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Date(
    @SerializedName("date")
    val date: String,
    @SerializedName("type")
    val type: String
) : Parcelable