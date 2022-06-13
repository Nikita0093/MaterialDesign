package com.example.materialdesign.viewmodel.picture

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentPictureOfTheDayBinding
import com.example.materialdesign.view.BottomNaviDrawerFragment
import com.example.materialdesign.view.MainActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar

class PictureOfTheDayFragment : Fragment() {

    var isMain = true

    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)

        })
        viewModel.getPictureOfTheDayByViewModel()

        val bottomSheetBehavior = BottomSheetBehavior.from(binding.lifeHack.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

        setActionBar()
        setFabListener()
        setDataNasa()


    }

    private fun setDataNasa() {


        binding.chipToday.setOnClickListener {
            Toast.makeText((requireContext() as MainActivity), "Test4", Toast.LENGTH_LONG).show()
            viewModel.getPictureOfTheDayByViewModel()
        }


        binding.chipYesterday.setOnClickListener {
            Toast.makeText((requireContext() as MainActivity), "Test5", Toast.LENGTH_LONG).show()
            viewModel.getPictureOfTheDayByViewModel()
        }


        binding.chipTheDayBeforeYesterday.setOnClickListener {
            Toast.makeText((requireContext() as MainActivity), "Test6", Toast.LENGTH_LONG).show()
            viewModel.getPictureOfTheDayByViewModel()
        }
    }

    private fun setFabListener() {
        binding.fab.setOnClickListener {
            if (isMain) {
                isMain = false
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.bottomAppBar.replaceMenu(R.menu.secondary_menu_bottom_bar)
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back
                    )
                )


            } else {
                isMain = true
                binding.bottomAppBar.navigationIcon =
                    (ContextCompat.getDrawable(requireContext(), R.drawable.ic_navigation))
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus
                    )
                )
            }
        }
    }

    private fun setActionBar() {
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.app_bar_search -> requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, WikiFragment.newInstance()).addToBackStack(" ")
                .commit()

            R.id.app_bar_fav -> Toast.makeText((requireContext() as MainActivity), "Test", Toast.LENGTH_LONG).show()


            android.R.id.home -> {
                BottomNaviDrawerFragment.newInstance().show(requireActivity().supportFragmentManager, " ")
            }
            R.id.secondary_app_bar_one -> {
                Toast.makeText((requireContext() as MainActivity), "Test2", Toast.LENGTH_LONG).show()
            }

        }

        return super.onOptionsItemSelected(item)

    }

    private fun renderData(pictureOfTheDayAppState: PictureOfTheDayAppState) {
        when (pictureOfTheDayAppState) {

            is PictureOfTheDayAppState.Error -> {
                binding.progressBar.visibility = View.INVISIBLE
                Snackbar.make(
                    requireView(),
                    "Ошибка: $pictureOfTheDayAppState",
                    Snackbar.LENGTH_LONG
                ).show()
                Log.d("@@@", "$pictureOfTheDayAppState")
            }

            is PictureOfTheDayAppState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }

            is PictureOfTheDayAppState.Success -> {
                binding.progressBar.visibility = View.INVISIBLE
                binding.lifeHack.bottomSheetTitle.text =
                    pictureOfTheDayAppState.pictureOfTheDayResponseData.title
                binding.lifeHack.bottomSheetExplanation.text =
                    pictureOfTheDayAppState.pictureOfTheDayResponseData.explanation
                binding.imageView.load(pictureOfTheDayAppState.pictureOfTheDayResponseData.hdurl) {
                    placeholder(R.drawable.nasa_logo)
                }
            }
        }


    }


    companion object {

        @JvmStatic
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}