package com.venmo.features.credit_card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.venmo.commons.navigation.routers.ProfileRouter
import com.venmo.features.credit_card.databinding.FragmentCreditCardBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CreditCardFragment: Fragment() {

    private val args: CreditCardFragmentArgs by navArgs()
    private val viewModel by viewModel<CreditCardViewModel> { parametersOf(args.user) }

    private val profileRouter by inject<ProfileRouter>()

    private var _binding: FragmentCreditCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.message.observe(viewLifecycleOwner, {
            binding.tvUserInfo.text = it
        })

        binding.btnAddCreditCard.setOnClickListener {
            findNavController().navigate(R.id.action_go_to_add_credit_card)
        }
        binding.btGoToProfile.setOnClickListener {
            profileRouter.navigate(findNavController())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}