package com.example.food.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.food.R
import com.example.food.models.Result
import com.example.food.utils.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup


class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundel: Result? = args?.getParcelable(RECIPE_RESULT_KEY)
        view.main_imageView.load(myBundel?.image)
        view.title_textView.text = myBundel?.title
        view.likes_textView.text = myBundel?.aggregateLikes.toString()
        view.time_textView.text = myBundel?.readyInMinutes.toString()
        myBundel?.summary.let {
            val summary = Jsoup.parse(it).text()
            view.summary_textView.text = summary
        }

        if (myBundel?.vegetarian == true) {
            view.vegetarian_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.vegetarian_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }
        if (myBundel?.vegan == true) {
            view.vegan_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.vegan_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }
        if (myBundel?.glutenFree == true) {
            view.gluten_free_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.gluten_free_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }
        if (myBundel?.dairyFree == true) {
            view.dairy_free_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.dairy_free_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }
        if (myBundel?.veryHealthy == true) {
            view.healthy_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.healthy_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }
        if (myBundel?.cheap == true) {
            view.cheap_imageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            view.cheap_textView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        return view;
    }
}