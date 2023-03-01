package space.riri.weatherfoxy.presentation.choiceanimal


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import space.riri.weatherfoxy.databinding.ChoiceAnimalBinding
import space.riri.weatherfoxy.presentation.choiceanimal.adapter.ChoiceAnimalAdapter

@AndroidEntryPoint
class ChoiceAnimalFragment : Fragment() {

    companion object {
        fun newInstance() = ChoiceAnimalFragment()
    }

    private lateinit var binding: ChoiceAnimalBinding

    private val adapter by lazy {
        ChoiceAnimalAdapter(viewModel::onAnimalSelected)
    }

    private val viewModel: ChoiceAnimalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChoiceAnimalBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listAnimals.adapter = adapter
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            binding.progressBar.isVisible = state.isLoading
            binding.choiceAnimal.isGone = state.isLoading
            adapter.addItems(state.items)
        }
    }
}
