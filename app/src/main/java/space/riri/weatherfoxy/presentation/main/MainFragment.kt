package space.riri.weatherfoxy.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.databinding.MainFragmentBinding
import space.riri.weatherfoxy.presentation.currentweather.CurrentWeatherFragment
import space.riri.weatherfoxy.presentation.hourlyweather.HourlyWeatherFragment

class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CurrentWeatherFragment.newInstance())
            .commitNow()
        binding.setupView()
    }

    private fun MainFragmentBinding.setupView() {
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CurrentWeatherFragment.newInstance())
                        .commitNow()
                    true
                }
                R.id.clock -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HourlyWeatherFragment.newInstance())
                        .commitNow()
                    true
                }
                R.id.graphic -> {
                    openFragment(CurrentWeatherFragment.newInstance())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_app_navigation_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //  Toast.makeText(requireContext(), item.title, Toast.LENGTH_SHORT).show()
        Log.d("test ----->", "onOptionsItemSelected: ${item} ")
        return super.onOptionsItemSelected(item)
    }
}